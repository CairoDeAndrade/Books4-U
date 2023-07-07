<?php

        session_start();
        include_once('C:/xampp/htdocs/books4u/frontend/screens/html/register_loan.html');
        include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
        

        if(isset($_POST['btnRegisterLoan'])){
            $bookIsbn = $_POST['bookIsbn'];
            $studentEnrollment = $_POST['studentEnrollment'];
            $startDate = date('Ymd', strtotime($_POST['startDate']));
            $endDate = date('Ymd', strtotime($_POST['endDate']));

            $array = array(
                'startDate' => $startDate,
                'endDate' => $endDate,
                'price' => 0,
                'bookIsbn' => $bookIsbn,
                'studentEnrollment' => $studentEnrollment
            );
            $json = json_encode($array);
            $options = array(
                CURLOPT_URL => 'http://26.2.87.114:8080/loans/insert/',
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
                if(empty($json['created'])){
                    $_SESSION['error'] = $json['message'];
                    echo $_SESSION['error'];
                    header('Location: http://localhost/books4u/frontend/php/loans/');
                }else{
                    if($json['created'] == true){
                        $_SESSION['created'] = true;
                        header('Location: http://localhost/books4u/frontend/php/loans/');
                    }else{
                        $_SESSION['created'] = false;
                        header('Location: http://localhost/books4u/frontend/php/loans/');
                    }
                }    
            }
        }
?>