package com.example.TodoManager.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TodoManager.entity.Task;
import com.example.TodoManager.repository.TaskRepository;
import com.opencsv.CSVWriter;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ArchiveController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/archive")
	public void downloadCsvFile(HttpServletResponse response) throws IOException {

		/*
		 * 参考:
		 * <https://terakoya.sejuku.net/question/detail/46821>
		 */

		// ファイル名の指定
		String fileName = "アーカイブ.csv";

		// 日本語名対応のファイルを出力できるようにエンコード
		String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");

		// コンテンツタイプの指定
		response.setContentType("text/csv; charset=UTF-8");

		/* ヘッダーの指定
		 * Content-Disposition: attachment ... ダウンロード対象であることを示す
		 */
		response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

		// BOM (Byte Order Mark)を使用する。
		// 文字コード設定？ これわかんないけどいれるとUTF-8であること示せるらしい
		response.getOutputStream().write(0xef);
		response.getOutputStream().write(0xbb);
		response.getOutputStream().write(0xbf);

		// UTF-8エンコーディングを指定してCSVを書き込み
		// ファイルを用意
		try (CSVWriter csvWriter = new CSVWriter(
				new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8))) {

			// 各表示項目ヘッダーを記述
			csvWriter.writeNext(new String[] { "No", "タスク名","タスク詳細", "作成日時", "完了期限日時", "重要度", "完/未"});
			
			// ログイン中のユーザーのアーカイブファイルを取得
			List<Task> archiveTasks = taskRepository.findAll();
			
			// 日付フォーマットを用意
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			// 取得した要素を書き込み
			for(Task t : archiveTasks) {
				csvWriter.writeNext(new String[] { 
						t.getTaskId().toString(),
						t.getTaskName(),
						t.getTaskContents(),
						dateFormat.format(t.getCreateDate()),
						dateFormat.format(t.getDeadlineDate()),
						t.getImportanceId().toString(),
						t.getCompleteFlag() ? "完了" : "未完了"
				});
			}
		} catch (Exception e) {
			throw new RuntimeException("CSV書き込み中にエラーが発生しました。", e);
		}
	}
}
