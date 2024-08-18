<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Index extends CI_Controller
{
	public function index()
	{
		$this->load->library('SpringBootAPI');

		$lokasis = SpringBootAPI::getLokasis();
		$proyeks = SpringBootAPI::getProyeks();

		$data = array(
			'view' => 'index',
			'title' => 'Welcome to CodeIgniter',
			'data' => array(
				'lokasis' => $lokasis,
				'proyeks' => $proyeks
			),
		);
		$this->load->view('layout/default', $data);
	}
}
