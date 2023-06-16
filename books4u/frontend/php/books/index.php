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
<style>
    body {
    background-color: #f1f1f1;
    font-family: Arial, sans-serif;
  }
  
  h1 {
    text-align: center;
  }
  
  .book-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-top: 20px;
  }
  
  .book {
    margin: 10px;
    width: 200px;
    text-align: center;
    background-color: #049760;
  }
  
  .book svg {
    width: 150px;
    height: 200px;
  }
  
  .book span {
    display: block;
    margin-top: 10px;
    font-size: 14px;
    font-weight: bold;
  }
</style>
<body>
    <div class="book-container">
        <?php 
            session_start();
            if(isset($_SESSION['deleted']) && $_SESSION['deleted'] === true){
                ?>
                        <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Livro Deletado!");
                                $('#text-alert').html("O livro foi deletado com sucesso!");
                                $('#book-delete').modal('hide');
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php 
                unset($_SESSION['deleted']);       
            }
            if(isset($_SESSION['updated']) && $_SESSION['updated'] === true){
                ?>
                        <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Livro Atualizado!");
                                $('#text-alert').html("O livro foi atualizado com sucesso!");
                                $('#book-delete').modal('hide');
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php 
                unset($_SESSION['updated']);  
            }
            $url = file_get_contents('http://26.2.87.114:8080/books/20');
            $json = json_decode($url);

            foreach($json as $key=> $data){
                    $array = array(
                        'id' => $data->id,
                        'copy' =>$data->copy,
                        'isbn' =>$data->isbn,
                        'bookName' => $data->name,
                        'bookStatus' =>$data->status,
                        'genreId' =>$data->genre->id,
                        'genreName' =>$data->genre->name,
                        'publishingCompanyId' =>$data->publishingCompany->id,
                        'publishingCompany' => $data->publishingCompany->name,
                        'authorId' =>$data->author->id,
                        'authorName' =>$data->author->name,
                        'localizationId' =>$data->localization->id,
                        'bookCase' => $data->localization->bookcaseNumber,
                        'shelf' => $data->localization->shelf
                    );
                    $json = json_encode($array);
                ?>
                <div class="book" value=" <?php echo $data->id ?>" onclick='openModal(<?php echo $json ?>)'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="64" height="64" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                        <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                    </svg>
                    <span><?php echo $data->name ?></span>
                </div>
                <?php
            }
        ?>
      </div> 
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
      <div class="modal" tabindex="-1" role="dialog" id="book-delete">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Deletar Livro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="text"></p>
            </div>
            <div class="modal-footer">
                <form method='POST' action='delete-book.php'>
                    <input type='text' name='idBook' id='form-delete' style='display: none;' value=''>
                    <input type='submit' name='btnDelete' id='btn-delete' value='Deletar'> 
                </form>      
            </div>
            </div>
        </div>
    </div>
    <div class="modal" tabindex="-1" role="dialog" id="book-edit">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Livro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method='POST' action='edit-book.php'>
                    <input type='text' name='idBook' value='' style='display: none' id='id-book-edit' required>
                    Número da Cópia: <input type='number' name='copyBook' value='' id='copy-book-edit' required>
                    <br>
                    ISBN : <input type='number' name='isbnBook' value='' id='isbn-book-edit' required>
                    <br>
                    Livro: <input type='text' name='nameBook' value='' id='name-book-edit' required>
                    <input type='text' name='bookStatus' value='' style='display:none;' id='book-status-edit' required>
                    <input type='text' name='genreId' value='' style='display:none;' id='genre-id-edit' required>
                    <br>
                    Gênero: <input type='text' name='genreName' value='' id='genre-name-edit' required>
                    <input type='text' name='publishingCompanyId' value='' style='display: none;' id='publishing-company-id-edit' required>
                    <input type='text' name='publishingCompanyName' value=''  id='publishing-company-name-edit' required style='display: none;' >
                    <input type='text' name='authorId' value=''  style='display: none;'id='author-id-edit' required>
                    <input type='text' name='authorName' value=''  id='author-name-edit' required style='display: none;'>
                    <input type='text' name='localizationId' value='' id='localization-id-edit' style='display: none;' required>
                    <br>
                    Estante: <input type='text' name='bookCase' value='' id='book-case-edit' required>
                    <br>
                    Prateleira: <input type='text' name='shelf' value='' id='shelf-edit' required>
                    <br>
                    <input type='submit' name='btnEdit' value='Editar'>
                </form>
            </div>
            <div class="modal-footer"> 

            </div>
            </div>
        </div>
    </div>
    <div class="modal" tabindex="-1" role="dialog" id="book-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Detalhes do Livro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="name-book"></p>
                <p id='author-book'></p>
                <p id='publishing-company'></p>
                <p id='copy'></p>
                <p id='book-case'></p>
                <p id='shelf'></p>
            </div>
            <div class="modal-footer">
                <button id='btn-edit' value='' onclick='editBook(value)'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                    </svg>
                </button>
                <button id='delete-book' value='' onclick='deleteBook(value)'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                        <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                    </svg>
                </button>    
            </div>
            </div>
        </div>
    </div>
</body>
</html>
<script>
        function openModal(id){
            $('#book-modal').modal('show');
            $('#name-book').html("Livro: <strong>" + id['bookName']);
            $('#author-book').html("Autor: <strong>" + id['authorName']);
            $('#publishing-company').html("Editora: <strong> " + id['publishingCompany']);
            $('#book-case').html("Estante: <strong> " + id['bookCase']);
            $('#shelf').html("Prateleira: <strong> " + id['shelf']);
            $('#copy').html("Cópia : <strong>" + id['copy']);
            $('#delete-book').val(id['id']);
            $('#form-delete').val(id['id']);

            $('#text').html("Você realmente deseja deletar o livro <strong>" + id['bookName'] + " </strong> da cópia <strong> " + id['copy'] + " </strong> ?");
       
            console.log(id);
            $('#id-book-edit').val(id['id']);
            $('#copy-book-edit').val(id['copy']);
            $('#isbn-book-edit').val(id['isbn']);
            $('#name-book-edit').val(id['bookName']);
            $('#book-status-edit').val(id['bookStatus']);
            $('#genre-id-edit').val(id['genreId']);
            $('#genre-name-edit').val(id['genreName']);
            $('#publishing-company-id-edit').val(id['publishingCompanyId']);
            $('#publishing-company-name-edit').val(id['publishingCompany']);
            $('#author-id-edit').val(id['authorId']);
            $('#author-name-edit').val(id['authorName']);
            $('#localization-id-edit').val(id['localizationId']);
            $('#book-case-edit').val(id['bookCase']);
            $('#shelf-edit').val(id['shelf']);
            
        }
        function deleteBook(id){
            $('#book-modal').modal('hide');
            $('#book-delete').modal('show');
        }
        function editBook(id){
            $('#book-edit').modal('show');
            $('#book-modal').modal('hide');
            console.log(id);
        }
</script>
<?php


?>