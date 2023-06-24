<?php
		
		include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
		// Recebe a consulta do usuário
		$q = $_GET['q'];

		
		$sql = mysqli_query($conexao,"SELECT *  FROM book_hml.tb_classrooms WHERE classroom_year LIKE '%$q%' ORDER BY classroom_year ASC");

		// Executa a consulta SQL e obtém os resultados

		// Formata os resultados em um array JSON compatível com o Select2
		$data = array();
		while ($row = mysqli_fetch_assoc($sql)) {
			$data[] = array(
				'classroomId' => $row['classroom_year'],
				'classroomName' => $row['classroom_year']
			);
		}

		// Retorna os resultados em formato JSON
		echo json_encode($data);
		
?>
