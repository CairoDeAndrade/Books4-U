<?php

session_start();

    include_once('C:/xampp/htdocs/books4u/frontend/screens/html/register_classroom.html');
    include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
    if(isset($_POST['register'])){
        $classroomYear = $_POST['classroomYear'];
        $classroomShift = $_POST['classroomShift'];
        $classroomStatus = true;
        
        $data = array(
            'classroomYear' => $classroomYear,
            'classroomShift' => $classroomShift,
            'classroomStatus' => $classroomStatus,
        );
        $json = json_encode($data);
        $options = array(
            CURLOPT_URL => 'http://10.10.28.214:8080/classrooms/',
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
                curl_close($curl);
                $json = json_decode($response, true);
                if($json['classroomYear'] == $classroomYear && $json['classroomShift'] == $classroomShift){
                    echo "Sala Cadastrada!";
                }else{
                    echo "Não Cadastrada!";
                }
        }

    }    

?>