<?php
defined('BASEPATH') or exit('No direct script access allowed');

class SpringBootAPI
{
    private $base_url = "";

    private $curl = null;
    private $header = array();
    private $result = null;

    public function __construct($method = "GET", $url = "", $data = array())
    {
        $this->base_url = API_URL;

        $this->initCurl();
        $this->setMethod($method);
        $this->setUrl($url);

        if ($method == "POST" || $method == "PUT" || $method == "DELETE")
            $this->setData($data);
    }

    public function __destruct()
    {
        curl_close($this->curl);
    }

    public function initCurl()
    {
        $this->curl = curl_init();
        curl_setopt($this->curl, CURLOPT_RETURNTRANSFER, true);
        $this->addHeader("Content-Type: application/json");
    }

    public function setMethod($method)
    {
        switch ($method) {
            case "POST":
                curl_setopt($this->curl, CURLOPT_POST, true);
                break;
            case "PUT":
                curl_setopt($this->curl, CURLOPT_CUSTOMREQUEST, "PUT");
                break;
            case "DELETE":
                curl_setopt($this->curl, CURLOPT_CUSTOMREQUEST, "DELETE");
                break;
            default:
                curl_setopt($this->curl, CURLOPT_HTTPGET, true);
                break;
        }
    }

    public function setUrl($url)
    {
        curl_setopt($this->curl, CURLOPT_URL, $this->base_url . $url);
    }

    public function addHeader($header)
    {
        array_push($this->header, $header);
        curl_setopt($this->curl, CURLOPT_HTTPHEADER, $this->header);
    }

    public function setData($data)
    {
        $data_string = json_encode($data);
        curl_setopt($this->curl, CURLOPT_POSTFIELDS, $data_string);
        $this->addHeader("Content-Length: " . strlen($data_string));
    }

    public function exec()
    {
        $this->result = curl_exec($this->curl);
        return json_decode($this->result);
    }

    public function getResult()
    {
        return $this->result;
    }

    public static function getLokasis()
    {
        $api = new SpringBootAPI("GET", "lokasi");
        return $api->exec();
    }

    public static function getLokasi($id)
    {
        $api = new SpringBootAPI("GET", "lokasi/" . $id);
        return $api->exec();
    }

    public static function deleteLokasi($id)
    {
        $api = new SpringBootAPI("DELETE", "lokasi/" . $id);
        return $api->exec();
    }

    public static function getProyeks()
    {
        $api = new SpringBootAPI("GET", "proyek");
        return $api->exec();
    }

    public static function getProyek($id)
    {
        $api = new SpringBootAPI("GET", "proyek/" . $id);
        return $api->exec();
    }

    public static function deleteProyek($id)
    {
        $api = new SpringBootAPI("DELETE", "proyek/" . $id);
        return $api->exec();
    }
}
