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
    <title>Empréstimos</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('http://26.155.119.91/books4u/frontend/designs/Fundo%20Sistema.jpg');
    }
  
  h1 {
    text-align: center;
  }
  .loan-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-top: 150px;
    max-width: 70%;
    margin-left: 15%;
    background-color: white;
    border-radius: 2.5%;
  }
  
  .loan{
    margin-top: 5%;
    text-align: center;
    color: #049760;
    cursor: pointer;
  }

  .loan span {
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
    <div class="loan-container">
        <div class="search">
            <div class="input-group mb-3">
                <form method="POST" style='display: flex;'>
                    <input type="text" class="form-control" name="valueBook" placeholder="Digite a Matrícula..." aria-label="Recipient's username" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" name="btnSearch" type="submit"  style="background-color: #049760; color: white;">Buscar</button>
                        </div>
                </form>
            </div>
        </div>
<?php
    session_start();
    include_once('C:/xampp/htdocs/books4u/frontend/screens/html/navbar.html');
    
    if(isset($_SESSION['error'])){
        $error = $_SESSION['error'];
        ?>
            <script>
                            $(document).ready(function(){   
                                $('#title-alert').html("Erro ao Cadastrar Empréstimo!");
                                $('#alert').modal('show');
                                setTimeout(function() {
                                $('#alert').modal('hide'); // Fecha o modal após 5 segundos (5000 milissegundos)
                                }, 3000);
                            });
                        </script>
                <?php
                unset($_SESSION['error']);

    }
    if(isset($_POST['btnSearch'])){
        $enrollment = $_POST['valueBook'];
        $get = file_get_contents('http://26.2.87.114:8080/loans/studentEnrollment='.$enrollment);
        $json = json_decode($get);
        
        ?>
        <div class="loan">
                    <table class="table table-dark">
                    <thead>
                        <tr>
                        <th scope="col">Livro</th>
                        <th scope="col">ISBN</th>
                        <th scope="col">Localização</th>
                        <th scope="col">Aluno</th>
                        <th scope="col">Matrícula</th>
                        <th scope="col">Sala</th>
                        <th scope="col">Data de Início</th>
                        <th scope="col">Data Final</th>
                        <th scope="col">Multa</th>
                        <th scope="col">Editar</th>
                        </tr>
                    </thead>
        <?php            
        foreach($json as $key => $data){

                $array = array(
                    'studentFullname' => $data->studentFullname,
                    'bookIsbn' => $data->bookIsbn,
                    'bookcaseNumber' => $data->bookcaseNumber,
                    'shelf' => $data->shelf,
                    'bookName' => $data->bookName,
                    'bookCopy' => $data->bookCopy,
                    'classroomYear' => $data->classroomYear,
                    'idLoan' => $data->idLoan,
                    'loanEndDate' => $data->loanEndDate,
                    'loanStartDate' => $data->loanStartDate,
                    'loanPrice' => $data->loanPrice,
                    'studentEnrollment' => $data->studentEnrollment
                );
                $json = json_encode($array);
                
            ?>
                    <tbody>
                        <tr value=" <?php echo $data->id ?>" onclick='openModal(<?php  echo $json ?>)'>
                        <td><?php echo $data->bookName ?></td>
                        <td><?php echo $data->bookIsbn ?></td>
                        <td><?php echo $data->bookcaseNumber ?></td>
                        <td><?php echo $data->studentFullname ?></td>
                        <td><?php echo $data->studentEnrollment ?></td>
                        <td><?php echo $data->classroomYear ?></td>
                        <td><?php echo date('d/m/Y', strtotime($data->loanStartDate)) ?></td>
                        <td><?php echo date('d/m/Y', strtotime($data->loanEndDate)) ?></td>
                        <td><?php echo $data->loanPrice ?></td>
                        <td>
                            <a href='edit-loan.php?idLoan=<?php echo $data->id ?> ' style='color: white;'>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                </svg>
                            </a>
                        <td>    
                        </tr>
                    </tbody>
            <?php
        }
    ?>
    </table>
    <?php    
    die();
    }
    else
        $url = file_get_contents('http://26.2.87.114:8080/loans/');
        $json = json_decode($url);

        ?>
        <div class="loan">
                    <table class="table table-dark">
                    <thead>
                        <tr>
                        <th scope="col">Livro</th>
                        <th scope="col">ISBN</th>
                        <th scope="col">Localização</th>
                        <th scope="col">Aluno</th>
                        <th scope="col">Matrícula</th>
                        <th scope="col">Sala</th>
                        <th scope="col">Data de Início</th>
                        <th scope="col">Data Final</th>
                        <th scope="col">Multa</th>
                        <th scope="col">Editar</th>
                        </tr>
                    </thead>
        <?php            
        foreach($json as $key => $data){

                $array = array(
                    'studentFullname' => $data->studentFullname,
                    'bookIsbn' => $data->bookIsbn,
                    'bookcaseNumber' => $data->bookcaseNumber,
                    'shelf' => $data->shelf,
                    'bookName' => $data->bookName,
                    'bookCopy' => $data->bookCopy,
                    'classroomYear' => $data->classroomYear,
                    'idLoan' => $data->idLoan,
                    'loanEndDate' => $data->loanEndDate,
                    'loanStartDate' => $data->loanStartDate,
                    'loanPrice' => $data->loanPrice,
                    'studentEnrollment' => $data->studentEnrollment
                );
                $json = json_encode($array);
                
            ?>
                    <tbody>
                        <tr value=" <?php echo $data->id ?>" onclick='openModal(<?php  echo $json ?>)'>
                        <td><?php echo $data->bookName ?></td>
                        <td><?php echo $data->bookIsbn ?></td>
                        <td><?php echo $data->bookcaseNumber ?></td>
                        <td><?php echo $data->studentFullname ?></td>
                        <td><?php echo $data->studentEnrollment ?></td>
                        <td><?php echo $data->classroomYear ?></td>
                        <td><?php echo date('d/m/Y', strtotime($data->loanStartDate)) ?></td>
                        <td><?php echo date('d/m/Y', strtotime($data->loanEndDate)) ?></td>
                        <td><?php echo $data->loanPrice ?></td>
                        <td>
                            <a href='edit-loan.php?idLoan=<?php echo $data->id ?> ' style='color: white;'>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                </svg>
                            </a>
                        <td>    
                        </tr>
                    </tbody>
            <?php
        }
    ?>
    </table>
</div>
</div>
<?php
    
?>
<div class="modal" tabindex="-1" role="dialog" id="alert">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id='title-alert'></h5>
            </div>
            <div class="modal-body">
                <p id="text-alert"><?php  echo $error;?></p>
            </div>
            <div class="modal-footer">

            </div>
            </div>
        </div>
</div>
<div class="modal" tabindex="-1" role="dialog" id="loan-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Detalhes do Empréstimo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="name-book"></p>
                <p id='isbn-book'></p>
                <p id='localization-book'></p>
                <p id='name-student'></p>
                <p id='enrollment-student'></p>
                <p id='classroom-student'></p>
                <p id='date-start'></p>
                <p id='date-end'></p>
                <p id='price'></p>
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
            $('#loan-modal').modal('show');

            $('#name-book').html("Livro: <strong>" + id['nameBook']);
            $('#isbn-book').html("ISBN: <strong>" + id['isbnBook']);
            $('#localization-book').html("Localização: <strong> " + id['localization']);
            $('#name-student').html("Aluno: <strong> " + id['nameStudent']);
            $('#enrollment-student').html("Matrícula: <strong> " + id['enrollment']);
            $('#classroom-student').html("Sala: <strong> " + id['classroom']);
            $('#date-start').html("Data Início: <strong> " + id['startDate']);
            $('#date-end').html("Data Fim: <strong> " + id['endDate']);
            $('#price').html("Multa: <strong> " + id['price']);
            
            $('#student-delete').val(id['id']);
            $('#form-delete').val(id['id']);

            $('#text').html("Você realmente deseja deletar o estudante <strong>" + id['fullname'] + " </strong> da matrícula <strong> " + id['enrollment'] + " </strong> ?");
       

            $('#id-student-edit').val(id['id']);
            $('#student-fullname-edit').val([id['fullname']]);
            $('#enrollment-student-edit').val([id['enrollment']]);
            $('#classroom-edit').val([id['year']]);
            $('#shift-edit').val([id['shift']]);
            
            
        }
</script>