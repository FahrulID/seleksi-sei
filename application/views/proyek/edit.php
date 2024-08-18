<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Edit Proyek</h2>
                </div>
            </div>
        </div>
        <form id="lokasi-create">
            <div class="form-group">
                <label for="lokasi">Nama Proyek</label>
                <input type="text" class="form-control" name="namaProyek" id="namaProyek" placeholder="Nama Proyek" value="<?php echo $proyek->data->namaProyek ?>">
            </div>
            <div class="form-group">
                <label for="client">Client</label>
                <input type="text" class="form-control" name="client" id="client" placeholder="Client" value="<?php echo $proyek->data->client ?>">
            </div>
            <div class="form-group">
                <label for="tglMulai">Tanggal Mulai</label>
                <input type="datetime-local" class="form-control" name="tglMulai" id="tglMulai" placeholder="Tanggal Mulai" value="<?php echo date('Y-m-d\TH:i', strtotime($proyek->data->tglMulai)) ?>">
            </div>
            <div class="form-group">
                <label for="tglSelesai">Tanggal Selesai</label>
                <input type="datetime-local" class="form-control" name="tglSelesai" id="tglSelesai" placeholder="Tanggal Selesai" value="<?php echo date('Y-m-d\TH:i', strtotime($proyek->data->tglSelesai)) ?>">
            </div>
            <div class="form-group">
                <label for="pimpinanProyek">Pimpinan Proyek</label>
                <input type="text" class="form-control" name="pimpinanProyek" id="pimpinanProyek" placeholder="Pimpinan Proyek" value="<?php echo $proyek->data->pimpinanProyek ?>">
            </div>
            <div class="form-group">
                <label for="keterangan">Keterangan</label>
                <input type="text" class="form-control" name="keterangan" id="keterangan" placeholder="Keterangan" value="<?php echo $proyek->data->keterangan ?>">
            </div>
            <div class="form-group">
                <label for="lokasiId">Lokasi</label>
                <select class="form-control" name="lokasiId" id="lokasiId">
                    <?php foreach ($lokasis->data as $lokasi) { ?>
                        <option value="<?php echo $lokasi->id ?>" <?php echo ($proyek->data->id == $lokasi->id) ? "selected" : "" ?>><?php echo $lokasi->namaLokasi ?></option>
                    <?php } ?>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Simpan</button>
        </form>
    </div>
</div>

<script>
    window.onload = function() {
        $(document).ready(function() {
            $('#lokasi-create').submit(function(e) {
                e.preventDefault();

                let dataJson = {
                    namaProyek: $('#namaProyek').val(),
                    client: $('#client').val(),
                    tglMulai: $('#tglMulai').val(),
                    tglSelesai: $('#tglSelesai').val(),
                    pimpinanProyek: $('#pimpinanProyek').val(),
                    keterangan: $('#keterangan').val(),
                    lokasiId: $('#lokasiId').val()
                };

                $.ajax({
                    url: '<?php echo API_URL ?>proyek/<?php echo $proyek->data->id ?>',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(dataJson),
                    success: function(response) {
                        alert('Data berhasil diperbaharui');
                        window.location.href = '<?php echo BASE_URL ?>';
                    },
                    error: function(response) {
                        alert('Data gagal diperbaharui');
                        console.log(response);
                    }
                });
            });
        });
    }
</script>