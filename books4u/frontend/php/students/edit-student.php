<?php

        if(isset($_POST['btnEditStudent'])){
            $idStudent = $_POST['idStudent'];
            $studentFullname = $_POST['studentFullname'];
            $enrollment = $_POST['enrollment'];
            $idClassroom = $_POST['idClassroom'];
            $year = $_POST['classroom'];
            $shift = $_POST['shift'];

            $classroom = array(
                'id' => $idClassroom,
                'year' => $year,
                'shift' => $shift,
                'status' => true
            );

            $array = array(
                'id' => $idStudent,
                'fullname' => $studentFullname,
                'enrollment' => $enrollment,
                'status' => true,
                'classroom' => $classroom
            );

            $url = 'http://26.2.87.114:8080/students/update/'.$idStudent;

            $ch = curl_init();

            
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($array, JSON_UNESCAPED_UNICODE));
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