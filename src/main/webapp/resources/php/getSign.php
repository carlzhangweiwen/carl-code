<?php



function getAccessToken(){
$appid='wxe6d7ae212a4d0cbe';
$secret='b86028a10fd5505798f047fc7d49b31e';
$name_key_accesstoken='accesstoken';//数据库中
$name_key_jsapi_ticket='jsapi_ticket';//数据库中


    
    //连接主数据库
                    $conn=mysql_connect(SAE_MYSQL_HOST_M.':'.SAE_MYSQL_PORT,SAE_MYSQL_USER,SAE_MYSQL_PASS);
                    
                    // 检测连接
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    } 
                    
                    if($conn)
                    {
                        $db_selected = mysql_select_db(SAE_MYSQL_DB,$conn);
                        
                        $sql="SELECT name_key, name_value, (CURRENT_TIMESTAMP-updatetimestamp)diff FROM wx_config WHERE  name_key in ('".$name_key_accesstoken."','".$name_key_jsapi_ticket."')";
                        
                        $rs = mysql_query($sql);
                        $count=mysql_num_rows($rs);
                        
                        while($row = mysql_fetch_row($rs))
                        {                           
                            $name_key = $row[0];
                            $name_value = $row[1];                            


                            if($name_key==$name_key_accesstoken){$accessToken = $name_value; $diff = $row[2]; }
                            if($name_key==$name_key_jsapi_ticket)$ticket = $name_value;
                            
                        }

                        //if($diff-3600>0){//超过一个小时重新获取token
                        if(true){  
                            mysql_query("BEGIN");//开始一个事务
							mysql_query("SET AUTOCOMMIT=0"); //设置事务不自动commit 
                            //accesstoken update...
                            $url='https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid='.$appid.'&secret='.$secret;
                            $html = httpGet($url);                                    
                            $result = json_decode($html);
                            $accessToken = $result->access_token;                            
                            
                            $sql="update  wx_config set name_value ='".$accessToken."', updatetimestamp=CURRENT_TIMESTAMP where name_key='".$name_key_accesstoken."'";
                          
                            mysql_query($sql);
                            
                            //jsapi_ticket update...
                            $url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=".$accessToken."&type=jsapi";
                            $html = httpGet($url);                                    
                            $result = json_decode($html);
                            $ticket = $result->ticket;                            
                            
                            $sql="update  wx_config set name_value ='".$ticket."', updatetimestamp=CURRENT_TIMESTAMP where name_key='".$name_key_jsapi_ticket."'";
                            mysql_query($sql);
                            mysql_query("COMMIT");
                        }

                                                
                        //关闭数据库
                        mysql_close($conn); 
                        
                        $sign = getSignPackage($ticket);
                               
                        //return json object.
                        $obj->appid =$appid;
                        $obj->signature = $sign['signature']; 
                        $obj->nonceStr = $sign['nonceStr'];
                        $obj->timestamp = $sign['timestamp'];
                        $obj->access_token = $accessToken;
                        $obj->url = $sign['url'];
                        $obj->string = $sign['string'];
                        $obj->ticket = $ticket;
                        echo json_encode($obj); 

                    }
    

}

  function getSignPackage($jsapiTicket) {
    $timestamp = time();
    $nonceStr = createNonceStr();


      $myurl = $_POST['curl'];
    // 这里参数的顺序要按照 key 值 ASCII 码升序排序
    $string = "jsapi_ticket=".$jsapiTicket."&noncestr=".$nonceStr."&timestamp=".$timestamp."&url=".$myurl;

    $signature = sha1($string);

    $signPackage = array(
	"signature" => $signature,
      "nonceStr"  => $nonceStr,
      "timestamp" => $timestamp,
      "url"       => $myurl,
        "string"=> $string

    );
    return $signPackage; 
  }

  function createNonceStr($length = 16) {
    $chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    $str = "";
    for ($i = 0; $i < $length; $i++) {
      $str .= substr($chars, mt_rand(0, strlen($chars) - 1), 1);
    }
    return $str;
  }
  function httpGet($url) {
    $curl = curl_init();
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_TIMEOUT, 500);
    curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
    curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
    curl_setopt($curl, CURLOPT_URL, $url);

    $res = curl_exec($curl);
    curl_close($curl);

    return $res;
  }


getAccessToken();
?>