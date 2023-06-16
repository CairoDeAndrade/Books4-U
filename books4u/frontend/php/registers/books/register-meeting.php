<?php

session_start();
if(isset($_POST['submit'])){
    include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
    $bookIsbn = $_POST['isbn'];
        $array = array(
            'bookCopy' => 1,
            'bookIsbn' => $bookIsbn,
            'bookName' => $_POST['titulo'],
            'bookStatus' => true,
            'genreName' => $_POST['genero'],
            'publishingCompanyName' => $_POST['editora'],
            'authorName' => $_POST['autor'],
            'bookcaseNumber' => $_POST['estante'],
            'shelf' => $_POST['prateleira']
        );
        $json = json_encode($array);
        $options = array(
            CURLOPT_URL => 'http://26.2.87.114:8080/books/insert/',
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => $json,
            CURLOPT_HTTPHEADER => array(
            'Content-Type: application/json',
            'Content-Length: ' . strlen($json)
            ),
            CURLOPT_RETURNTRANSFER => true 
        );
        $curl = curl_init();
        curl_setopt_array($curl, $options);
    
        // Executa a requisição
        $response = curl_exec($curl);
    
        if(curl_errno($curl)){
                $error = curl_error($curl);
                echo "Erro na requisição cURL: " . $error;
        } else {
            // Finaliza o curl
            curl_close($curl);
    
            // Verifica o resultado
            $json = json_decode($response, true);
            if($json['created'] == true){
                $_SESSION['bookName'] = $_POST['titulo'];
                $_SESSION['created'] = true;
                header('Location: index.php');
            }else{
                $_SESSION['created'] = false;
                header('Location: index.php');
            }
        }
}
?>