<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	できたー
</body>
</html>
<!DOCTYPE html>
<html>
<!DOCTYPE html >
<html xmlns:th="http://www.thymeleaf.org" lang="ja">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta charset="UTF-8">
<title>Todo</title>
<style>
	body{	 
		font-family: Arial, sans-serif;
		margin: 20px;
		padding: 20px;
	}
	h1, h2 {
		color: #333;
	}
	
	table{
		border-collapse: collapse;		
		width: 100%;
		margin-top: 20px;
		
	}
	th, td {
		border: 1px solid #ccc;
		padding: 10px;
		text-align: center;
	}
	th {
		background-color: aqua;
	}
	td:empty{
		background-color: #f4f4f4;
	}		
	#calender {
		margin-right: 10px;
		padding: 20px;
	}
	#clock {
		margin-left: 10px;
		font-size: 24px;
		text-align: center;
		color: #555;
	 }
	
</style>
</head>	

<body>
	できたー
</body>
</html>
<!-- Todoセクション -->
<section id ="todo">
<h1>Todo</h1>
<table><tr>
	<th>No</th><th>タスク名</th><th>完了期限日時</th><th>重要度</th><th>完了</th>
</tr></table>
</section>

<!-- カレンダーセクション-->
<script>
function generateCalender() {
	    const now = new Date();
	    const hours = now.getHours().toString().padStart(2, '0');
	    const minutes = now.getMinutes(). toString(). padStart(2, '0');
	    const second = now.getSeconds(). toString(). padStart(2, '0');
	    document.getElementById('time').textContent = '${hours}:${minutes}:${seconds}';
	  }  
	//	const calenderBody = document.getElementById('calender-body');
	//	calenderBody.innerHTML = '';
	//	const firstDay = new Date(year, month, 1).getDay();
	//	const daysInMonth = new Date(year, month +1, 0).getDate();
		
		let date = 1;
		for (let i = 0; i < 6; i++){
			const row = document.createElement('tr');
			for (let j = 0; j < 7; j++){
				const cell=document.createElement('td');
				if (i === 0 && j < firstDay){
					cell.textContent = '';					
				} else if (date > daysInMonth){
					cell.textContent = '';
				} else {
					cell.textContent = date;
					date++;
				}
				row.appendChild(cell);
			}
			calenderBody.appendChild(row);
		}
	}	
	
</script>
	
<section id="calender">
<h2>Calender</h2>
<table><thead><tr>
	<th>日</th><th>月</th><th>火</th><th>水</th><th>木</th><th>金</th><th>土</th>
</tr></table></table>
</section>
	
<ul><li th:each="item : ${menuItem}" th:text="${item}">	</li></ul>
<div id="calender">



<div id="clock">
<h2>デジタル時計</h2><p id="time"></p>
</div>
 <!-- デジタル時計を表示する関数 -->
 
<script>
	
	
	function updateClock(){
		const now = new Date();
		const hours = String(now.getHours()).padStart(2, '0');
            const minutes = String(now.getMinutes()).padStart(2, '0');
            const seconds = String(now.getSeconds()).padStart(2, '0');
            document.getElementById('time').textContent = `${hours}:${minutes}:${seconds}`;
        }
       
        const now = new Date();
        generateCalender(now.getFullYear(), now.getMonth());
        setInterval(updateClock, 1000);
             
</script>
</body>		
</html>