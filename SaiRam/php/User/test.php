<?php
$command = escapeshellcmd('sai.py');
$output = shell_exec($command);
echo $output;
?>