<?php
class search{
function lookup($search){
    $curl = curl_init("curl -XGET darksearch.com/api/{$search}/1");
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $response_data = curl_exec($curl);
    curl_close($curl);
    $lookup_data_array = json_decode($response_data,true); // Convert to array
    return $response_data;
}


 
}
?>