<?php 

        include_once('config.php');

        if(isset($_POST['adicionar'])){
            $json = file_get_contents("./json/ultima.json");
            $data = json_decode($json);

            foreach ($data as $key => $value) {
                $sql = mysqli_query($conexao, "INSERT INTO book_hml.tb_books(id_book, copy_book, isbn_book, name_book, status_book, tb_genre_idtb_genre, tb_publishing_company_id_publishing_company, tb_authors_id_authors, tb_books_localization_id_books_localization) VALUES
                ('$value->id_book' , '$value->book_copy' , '$value->isbn_book' , '$value->book_name' , '$value->status_book' , '$value->id_genre' , '$value->id_editora' , '$value->id_author' , '$value->id_localization')");
            }
        }
        echo "<form method='POST'>";
        echo "<input type='submit' name='adicionar'>";
        echo "</form>";
?>