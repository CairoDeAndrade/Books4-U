<!DOCTYPE html>
<html lang="ptbr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href="books.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Livros</title>
</head>
<?php

session_start();

include_once('C:/xampp/htdocs/books4u/frontend/screens/html/register_book.html');
include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
include_once('C:/xampp/htdocs/books4u/frontend/screens/html/navbar.html');

?>
<?php
        if(isset($_SESSION['created'])){
                ?>
                        <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Livro Inserido!");
                                $('#text-alert').html("O livro foi inserido com sucesso!");
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php
                unset($_SESSION['created']);
        }else{
            include_once('C:/xampp/htdocs/books4u/frontend/select2/select2.html');
?>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>
            <script>
                $(document).ready(function(){
                    $('.genero').select2({
                        // minimumInputLength: 2, // Número mínimo de caracteres para exibir resultados
                        ajax: {
                            url: "dropdown-genres.php",
                            dataType: 'json',
                            delay: 250, // Tempo de espera em milissegundos antes de enviar a solicitação
                            data: function (params) {
                                return {
                                    q: params.term // Consulta de pesquisa
                                };
                            },
                            processResults: function (data) {
                                return {
                                    results: data.map(function (item) {
                                        return {
                                            id: item.genreId,
                                            text: item.genreName
                                        };
                                    })
                                };
                            },
                            cache: true // Ativar ou desativar o cache de resultados
                        }
                    });
                });
            </script>
            <?php
        }
    ?>

<div class="modal" tabindex="-1" role="dialog" id="alert">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id='title-alert'></h5>
            </div>
            <div class="modal-body">
                <p id="text-alert"></p>
            </div>
            <div class="modal-footer">

            </div>
            </div>
        </div>
</div>
<script>
		const form = document.querySelector('form');
		const isbnInput = document.querySelector('#isbn');
		const tituloInput = document.querySelector('#titulo');
		const autorInput = document.querySelector('#autor');
		const editoraInput = document.querySelector('#editora');
		const anoInput = document.querySelector('#ano');
		const paginasInput = document.querySelector('#paginas');

		isbnInput.addEventListener('input', () => {
			const isbn = isbnInput.value.replace(/[^0-9]/g, ''); // remove caracteres não numéricos
			if (isbn.length === 10 || isbn.length === 13) {
				const url = `https://brasilapi.com.br/api/isbn/v1/${isbn}`;

				fetch(url)
					.then(response => response.json())
					.then(data => {
						if (data.title) {
							tituloInput.value = data.title;
						}
						if (data.authors) {
							autorInput.value = data.authors[0];
						}
						if (data.publisher) {
							editoraInput.value = data.publisher;
						}
                        console.log(data);
					})
					.catch(error => console.error(error));
			} else {
				tituloInput.value = '';
				autorInput.value = '';
				editoraInput.value = '';
				anoInput.value = '';
				paginasInput.value = '';
			}
		});
	</script>