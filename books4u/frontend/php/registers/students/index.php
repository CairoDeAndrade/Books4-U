<?php

session_start();

if(empty($_SESSION['userEmail'])){
    header('Location: /books4u/frontend/php/login.php');
}else{
    include_once('/books4u/frontend/php/config.php');

    
}

?>