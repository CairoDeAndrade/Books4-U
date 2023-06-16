<?php

        if(isset($_POST['btnDelete'])){
            $id = $_POST['idBook'];
            echo $id;

                $url = 'http://26.2.87.114:8080/books/delete/'.$id; 
                $ch = curl_init($url);
                curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE');
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

                $response = curl_exec($ch);

                if ($response === false) {
                    echo 'Erro ao fazer a solicitação: ' . curl_error($ch);
                }

                curl_close($ch);

                $json = json_decode($response, true);
                if($json['deleted'] === true){
                        session_start();
                        $_SESSION['deleted'] = true;
                        header('Location:index.php');
                }
        }
?>