<?php
		
		include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
		// Recebe a consulta do usuário
		$q = $_GET['q'];

		
		$sql = mysqli_query($conexao,"SELECT *  FROM book_hml.tb_genres WHERE genre_name LIKE '%$q%'");

		// Executa a consulta SQL e obtém os resultados

		// Formata os resultados em um array JSON compatível com o Select2
		$data = array();
		while ($row = mysqli_fetch_assoc($sql)) {
			$data[] = array(
				'genreId' => $row['genre_name'],
				'genreName' => $row['genre_name']
			);
		}

		// Retorna os resultados em formato JSON
		echo json_encode($data);
		
?>
