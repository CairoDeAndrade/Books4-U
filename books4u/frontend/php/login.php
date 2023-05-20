<?php
include_once('config.php');
include_once('../screens/html/login2.html');

if(isset($_SESSION['userEmail'])){
        
}else{
        if(isset($_POST['btnLogin'])){
                $userEmail = $_POST['email'];
                $userPassword = $_POST['password'];

                $data = array(
                        'userEmail' => $userEmail,
                        'userPassword' => $userPassword,
                );
                $json = json_encode($data);
                $options = array(
                        CURLOPT_URL => 'http://26.2.87.114:8080/users/login/',
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

                        // Verifica se a resposta é true ou false
                        if(isset($json['logged']) && $json['logged'] === true){
                                
                                $_SESSION['userEmail'] = $userEmail;
                                header('Location: /books4u/frontend/php/registers/books');
                        } else {
                                echo "Não!";
                        }
                }
        }
}
?>
