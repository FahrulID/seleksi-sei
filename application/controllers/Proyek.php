<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Proyek extends CI_Controller
{
	public function create()
	{
		$this->load->library('SpringBootAPI');

		$lokasis = SpringBootAPI::getLokasis();

		$data = array(
			'view' => 'proyek/create',
			'title' => 'Tambah Proyek',
			'data' => array(
				'lokasis' => $lokasis,
			),
		);
		$this->load->view('layout/default', $data);
	}

	public function edit($id)
	{
		$this->load->library('SpringBootAPI');

		$proyek = SpringBootAPI::getProyek($id);
		$lokasis = SpringBootAPI::getLokasis();

		$data = array(
			'view' => 'proyek/edit',
			'title' => 'Edit Proyek',
			'data' => array(
				'proyek' => $proyek,
				'lokasis' => $lokasis,
			),
		);
		$this->load->view('layout/default', $data);
	}

	public function delete($id)
	{
		$this->load->library('SpringBootAPI');

		SpringBootAPI::deleteProyek($id);

		redirect(base_url());
	}
}
