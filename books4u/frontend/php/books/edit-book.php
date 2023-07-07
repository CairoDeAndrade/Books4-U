<?php

        if(isset($_POST['btnEdit'])){
            $id = $_POST['idBook'];
            $copy = $_POST['copyBook'];
            $isbn = $_POST['isbnBook'];
            $bookName = strtoupper($_POST['nameBook']);
            $bookStatus = $_POST['bookStatus'];
            $borrowed = $_POST['borrowed'];
            $genreId = $_POST['genreId'];
            $genreName = strtoupper($_POST['genreName']);
            $publishingCompanyId = $_POST['publishingCompanyId'];
            $publishingCompany =  strtoupper($_POST['publishingCompanyName']);
            $authorId = $_POST['authorId'];
            $authorName = strtoupper($_POST['authorName']);
            $localizationId = $_POST['localizationId'];
            $bookCase = $_POST['bookCase'];
            $bookShelf = $_POST['shelf'];

            $arrayGenre = array(
                'id' => $genreId,
                'name' => $genreName
            );
            $arrayPublishingCompany = array(
                'id' => $publishingCompanyId,
                'name' => $publishingCompany
            );
            $arrayAuthor = array(
                'id' => $authorId,
                'name' => $authorName,
                'status' => true
            );
            $arrayLocalization = array(
                'id' => $localizationId,
                'bookcaseNumber' => $bookCase,
                'shelf' => $bookShelf
            );
            $data = array(
                'id' => $id,
                'copy' => $copy,
                'isbn' => $isbn,
                'name' => $bookName,
                'status' => $bookStatus,
                'borrowed' => $borrowed,
                'genre' => $arrayGenre,
                'publishingCompany' => $arrayPublishingCompany,
                'author' => $arrayAuthor,
                'localization' => $arrayLocalization
            );
        
            $url = 'http://26.2.87.114:8080/books/update/'.$id;

            
            $ch = curl_init();

            
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data, JSON_UNESCAPED_UNICODE));
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));

            // Executar a solicitação cURL
            $response = curl_exec($ch);

            
            if(curl_errno($ch)){
                echo 'Erro na solicitação cURL: ' . curl_error($ch);
            }else{
                curl_close($ch);
                
                $result = json_decode($response, true);
                if($result['updated'] === true){
                    session_start();
                    $_SESSION['updated'] = true;
                    header('Location: index.php');
                }
            }
        }

?>