<?php

include_once('config.php');
include_once('login.html');

if(isset($_POST['btnLogin'])){
        $emailUser = $_POST['emailUser'];
        $passwordUser = $_POST['passwordUser'];

        $data  = array(
                'email' => $emailUser,
                'password' => $passwordUser,
        );
        $json = json_encode($data);
        $options = array(
                CURLOPT_URL => 'http://0.0.0:8080/users/login/'. $email_user,
                CURLOPT_POST => true,
                CURLOPT_POSTFIELDS => $json,
                CURLOPT_HTTPHEADER => array(
                    'Content-Type: application/json',
                    'Content-Length: ' . strlen($json)
                )
        );
        $curl = curl_init();
        curl_setopt_array($curl, $options);

        // Executa a requisição
        $response = curl_exec($curl);

        // Finaliza o curl

        // Verifica o resultado
        if ($response === false) {
                echo 'Não Logado ';
        } else {
                session_start();
                $_SESSION['emailUser'] = $emailUser;
                header('Location: index.php');
        }
}
?>