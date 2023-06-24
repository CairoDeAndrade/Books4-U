<?php

session_start();


    include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
    include_once('C:/xampp/htdocs/books4u/frontend/screens/html/cadastro_aluno.html');
    include_once('C:/xampp/htdocs/books4u/frontend/select2/select2.html');

    if(isset($_POST['btnRegisterStudent'])){
        $fullname = $_POST['studentFullname'];
        $enrollment = $_POST['studentEnrollment'];
        $classroomNumber = $_POST['classroom'];

        $array = array(
            'fullname' => $fullname,
            'enrollment' => $enrollment,
            'status' => true,
            'classroomNumber' => $classroomNumber
        );
        $json = json_encode($array);
        $options = array(
            CURLOPT_URL => 'http://26.2.87.114:8080/students/insert/',
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
                $_SESSION['created'] = true;
                header('Location: http://localhost/books4u/frontend/php/students/index.php');
            }else{
                $_SESSION['created'] = false;
                header('Location: http://localhost/books4u/frontend/php/students/index.php');
            }
        }
    }
?>
        <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>
            <script>
                $(document).ready(function(){
                    $('#classroom').select2({
                        // minimumInputLength: 2, // Número mínimo de caracteres para exibir resultados
                        ajax: {
                            url: "classroom-dropbox.php",
                            dataType: 'json',
                            delay: 250, // Tempo de espera em milissegundos antes de enviar a solicitação
                            data: function (params) {
                                return {
                                    q: params.term // Consulta de pesquisa
                                };
                            },
                            processResults: function (data) {
                                return {
                                    results: data.map(function (item) {
                                        return {
                                            id: item.classroomId,
                                            text: item.classroomName
                                        };
                                    })
                                };
                                
                            },
                            cache: true // Ativar ou desativar o cache de resultados
                        }
                    });
                });
            </script>