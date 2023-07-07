<?php

        include_once('config.php');

        $sql = mysqli_query($conexao, "SELECT * FROM book_software.tb_students");
        while($result = mysqli_fetch_array($sql)){
            echo $result['student_name'];
            echo "<br>";
            echo $result['id'];
            echo "<br>";
        }

?>