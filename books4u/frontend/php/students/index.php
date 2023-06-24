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
    <title>Estudantes</title>
</head>
<style>
    
    body {
        font-family: Arial, sans-serif;
        background-image: url('http://26.155.119.91/books4u/frontend/designs/Fundo%20Sistema.jpg');
    }
  
  h1 {
    text-align: center;
  }
  
  .book-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-top: 150px;
    max-width: 70%;
    margin-left: 15%;
    background-color: white;
    border-radius: 2.5%;
  }
  
  .book {
    margin-top: 5%;
    width: 200px;
    text-align: center;
    color: #049760;
    cursor: pointer;
  }
  
  .book svg {
    width: 125px;
    height: 175px;
    color: black;
  }
  
  .book span {
    display: block;
    margin-top: 10px;
    font-size: 14px;
    font-weight: bold;
    color: black;
  }

  .search{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    position: absolute;
    margin-top: 1%;
  }
</style>
<body>
    <div class="book-container">
    <div class="search">
        <div class="input-group mb-3">
            <form method="POST" style='display: flex;'>
                <input type="text" class="form-control" name="valueBook" placeholder="Digite o Livro ou ISBN..." aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" name="btnSearch" type="submit"  style="background-color: #049760; color: white;">Buscar</button>
                    </div>
            </form>
        </div>
    </div>
        <?php 
            session_start();
            include_once('C:/xampp/htdocs/books4u/frontend/screens/html/navbar.html');
            
            if(isset($_SESSION['deleted']) && $_SESSION['deleted'] === true){
                ?>
                        <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Estudante Deletado!");
                                $('#text-alert').html("O estudante foi deletado com sucesso!");
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
                                $('#title-alert').html("Estudante Atualizado!");
                                $('#text-alert').html("O estudante foi atualizado com sucesso!");
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php 
                unset($_SESSION['updated']);  
            }
            if(isset($_SESSION['created']) && $_SESSION['created'] === true){
                ?>
                        <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Estudante Criado!");
                                $('#text-alert').html("O estudante foi criado com sucesso!");
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php 
                unset($_SESSION['created']);  
            }
            if(isset($_POST['btnSearch'])){
                if(is_numeric($_POST['valueBook'])){
                    $enrollment = $_POST['valueBook'];
                    $url = file_get_contents('http://26.2.87.114:8080/students/enrollment='.$enrollment);
                    $data = json_decode($url);

                    $array = array(
                        'id' => $data->id,
                        'fullname' => $data->fullname,
                        'enrollment' => $data->enrollment,
                        'status' => $data->status,
                        'idClassroom' =>$data->classroom->id,
                        'year' => $data->classroom->year,
                        'shift' => $data->classroom->shift,
                        'statusClassroom' => $data->classroom->status
                    );
                    $json = json_encode($array);
                    
                    ?>
                    <div class="book" value=" <?php echo $json['id'] ?>" onclick='openModal(<?php  echo $json ?>)'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                        </svg>
                        <span><?php echo "Nome: " .$data->fullname ?></span>
                        <span><?php echo "Turma: " .$data->classroom->year ?></span>
                    </div>
                        <?php
                    
                
                }else{
                    $studentPost = $_POST['valueBook'];
                    $student = str_replace(" ", "%20", $studentPost);
                    $url = file_get_contents('http://26.2.87.114:8080/students/name='.$student);
                    $json = json_decode($url);
        
                    
                    foreach($json as $key=> $data){
                        $array = array(
                            'id' => $data->id,
                            'fullname' => $data->fullname,
                            'enrollment' => $data->enrollment,
                            'status' => $data->status,
                            'idClassroom' =>$data->classroom->id,
                            'year' => $data->classroom->year,
                            'shift' => $data->classroom->shift,
                            'statusClassroom' => $data->classroom->status
                        );
                        $json = json_encode($array);
                    ?>
                    <div class="book" value=" <?php echo $data->id ?>" onclick='openModal(<?php echo $json ?>)'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                        </svg>
                        <span><?php echo "Nome: " .$data->fullname ?></span>
                        <span><?php echo "Turma: " .$data->classroom->year ?></span>
                    </div>
                        <?php
                    }
                }
            
            }else{
                $url = file_get_contents('http://26.2.87.114:8080/students/10');
                $json = json_decode($url);

                
                foreach($json as $key=> $data){
                        $array = array(
                            'id' => $data->id,
                            'fullname' => $data->fullname,
                            'enrollment' => $data->enrollment,
                            'status' => $data->status,
                            'idClassroom' =>$data->classroom->id,
                            'year' => $data->classroom->year,
                            'shift' => $data->classroom->shift,
                            'statusClassroom' => $data->classroom->status
                        );
                        $json = json_encode($array);
                    ?>
                    <div class="book" value=" <?php echo $data->id ?>" onclick='openModal(<?php echo $json ?>)'>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                        </svg>
                        <span><?php echo "Nome: " .$data->fullname ?></span>
                        <span><?php echo "Turma: " .$data->classroom->year ?></span>
                    </div>
                    <?php
                }
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
      <div class="modal" tabindex="-1" role="dialog" id="student-delete">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Deletar Estudante</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="text"></p>
            </div>
            <div class="modal-footer">
                <form method='POST' action='delete-student.php'>
                    <input type='text' name='idStudent' id='form-delete' style='display: none;' value=''>
                    <input type='submit' name='btnDelete' id='btn-delete' value='Deletar'> 
                </form>      
            </div>
            </div>
        </div>
    </div>
    <div class="modal" tabindex="-1" role="dialog" id="student-edit">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Estudante</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method='POST' action='edit-student.php'>
                    <input type='number' name='idStudent' style='display: none;' id='id-student-edit'>
                    Nome: <input type='text' name='studentFullname' id='student-fullname-edit'>
                   <br>
                    Matricula: <input type='number' name='enrollment' id='enrollment-student-edit'>
                    <br>
                    <input type='text' name='idClassroom' style='display: none'; id='id-classroom-edit'>
                    Sala: <input type='number' name='classroom' id='classroom-edit'>
                    <br>
                    <input type='text' name='shift' id='shift-edit' style='display: none;'>
                    <br><br>
                    <input type='submit' name='btnEditStudent' value='Editar'>
                </form>
            </div>
            <div class="modal-footer"> 

            </div>
            </div>
        </div>
    </div>
    <div class="modal" tabindex="-1" role="dialog" id="student-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Detalhes do Estudante</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="name-student"></p>
                <p id='enrollment-student'></p>
                <p id='year-student'></p>
                <p id='shift-student'></p>
            </div>
            <div class="modal-footer">
                <button id='btn-edit' value='' onclick='editStudent(value)'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                    </svg>
                </button>
                <button id='delete-student' value='' onclick='deleteStudent(value)'>
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
            $('#student-modal').modal('show');

            $('#name-student').html("Aluno: <strong>" + id['fullname']);
            $('#enrollment-student').html("Matrícula: <strong>" + id['enrollment']);
            $('#year-student').html("Sala: <strong> " + id['year']);
            $('#shift-student').html("Turno: <strong> " + id['shift']);

            $('#student-delete').val(id['id']);
            $('#form-delete').val(id['id']);

            $('#text').html("Você realmente deseja deletar o estudante <strong>" + id['fullname'] + " </strong> da matrícula <strong> " + id['enrollment'] + " </strong> ?");
       

            $('#id-student-edit').val(id['id']);
            $('#student-fullname-edit').val([id['fullname']]);
            $('#enrollment-student-edit').val([id['enrollment']]);
            $('#classroom-edit').val([id['year']]);
            $('#shift-edit').val([id['shift']]);
            
            
        }
        function deleteStudent(id){
            $('#student-modal').modal('hide');
            $('#student-delete').modal('show');
        }
        function editStudent(id){
            $('#student-edit').modal('show');
            $('#student-modal').modal('hide');
            console.log(id);
        }
</script>
<?php
        
?>