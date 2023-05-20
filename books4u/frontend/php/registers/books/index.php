<?php

session_start();

include_once('C:/xampp/htdocs/books4u/frontend/screens/html/register_book.html');
include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
//include_once('C:/xampp/htdocs/books4u/frontend/screens/html/navbar.html');

if(isset($_POST['submit'])){
    $bookIsbn = $_POST['isbn'];
    
    $data = array(
        'isbnBook' => $bookIsbn,
    );
    $json = json_encode($data);

    $options = array(
        CURLOPT_URL => 'http://26.2.87.114:8080/books/',
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

        if($json['exists'] === true){
            echo "Existe";
        }else{
            echo $bookIsbn;
        }
    }

}
?>