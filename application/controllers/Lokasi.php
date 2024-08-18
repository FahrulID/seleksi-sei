<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Lokasi extends CI_Controller
{
    public function create()
    {
        $data = array(
            'view' => 'lokasi/create',
            'title' => 'Tambah Lokasi',
        );
        $this->load->view('layout/default', $data);
    }

    public function edit($id)
    {
        $this->load->library('SpringBootAPI');

        $lokasi = SpringBootAPI::getLokasi($id);

        $data = array(
            'view' => 'lokasi/edit',
            'title' => 'Edit Lokasi',
            'data' => array(
                'lokasi' => $lokasi,
            ),
        );
        $this->load->view('layout/default', $data);
    }

    public function delete($id)
    {
        $this->load->library('SpringBootAPI');

        SpringBootAPI::deleteLokasi($id);

        redirect(base_url());
    }
}
