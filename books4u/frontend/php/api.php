<?php

        include_once('api.html');

        if(isset($_POST['submit'])){
            $isbn = $_POST['isbn'];
            $titulo = $_POST['titulo'];
            $autores = $_POST['autores'];
            $editora = $_POST['editora'];
            $matricula = $_POST['matricula'];
            echo "ISBN " . $isbn;
            echo "<br>";
            echo "Titulo " . $titulo;
            echo "<br>";
            echo "Autor " . $autores;
            echo "<br>";
            echo "Editora " . $editora;
            echo "<br>";
            echo "Matricula do Aluno " . $matricula;
            echo "<br>";
            $url = "https://covers.openlibrary.org/b/isbn/";
            $formato = ".jpg";
            $concat = $url . $isbn . $formato;
            list($largura, $altura) = getimagesize($concat);
            if($largura < 2 && $altura < 2){
                echo "Não existe imagem!";
            }else{
                echo "<img src='$concat'></img>";
            }
        }
?>
