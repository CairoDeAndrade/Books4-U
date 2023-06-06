<?php

session_start();

include_once('C:/xampp/htdocs/books4u/frontend/screens/html/register_book.html');
include_once('C:/xampp/htdocs/books4u/frontend/php/config.php');
include_once('C:/xampp/htdocs/books4u/frontend/screens/html/navbar.html');
include_once('C:/xampp/htdocs/books4u/frontend/select2/select2.html');

if(isset($_POST['submit'])){
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
                echo "Livro inserido";
            }else{
                echo "Livro não inserido";
            }
        }
}
?>
<script>
    $(document).ready(function(){
        $('.js-select2').select2({
            minimumInputLength: 2, // Número mínimo de caracteres para exibir resultados
            ajax: {
                url: "dropdown.php",
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
                                id: item.genreId,
                                text: item.genreName
                            };
                        })
                    };
                },
                cache: true // Ativar ou desativar o cache de resultados
            }
        });
        
    });
</script>
