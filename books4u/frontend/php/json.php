<?php 

        include_once('config.php');

        if(isset($_POST['adicionar'])){
            $json = file_get_contents("./json/classroom.json");
            $data = json_decode($json);

            foreach ($data as $key => $value) {
                
                $sql = mysqli_query($conexao, "INSERT IGNORE INTO book_hml.tb_classroom (classroom_year, classroom_shift, classroom_status)VALUES
                ('$value->year_classroom' , '$value->shift_classroom' , '$value->stats_classroom')");
                
            }
        }
        echo "<form method='POST'>";
        echo "<input type='submit' name='adicionar'>";
        echo "</form>";
?>