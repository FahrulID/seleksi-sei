<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Tambah Proyek</h2>
                </div>
            </div>
        </div>
        <form id="lokasi-create">
            <div class="form-group">
                <label for="lokasi">Nama Proyek</label>
                <input type="text" class="form-control" name="namaProyek" id="namaProyek" placeholder="Nama Proyek">
            </div>
            <div class="form-group">
                <label for="client">Client</label>
                <input type="text" class="form-control" name="client" id="client" placeholder="Client">
            </div>
            <div class="form-group">
                <label for="tglMulai">Tanggal Mulai</label>
                <input type="datetime-local" class="form-control" name="tglMulai" id="tglMulai" placeholder="Tanggal Mulai">
            </div>
            <div class="form-group">
                <label for="tglSelesai">Tanggal Selesai</label>
                <input type="datetime-local" class="form-control" name="tglSelesai" id="tglSelesai" placeholder="Tanggal Selesai">
            </div>
            <div class="form-group">
                <label for="pimpinanProyek">Pimpinan Proyek</label>
                <input type="text" class="form-control" name="pimpinanProyek" id="pimpinanProyek" placeholder="Pimpinan Proyek">
            </div>
            <div class="form-group">
                <label for="keterangan">Keterangan</label>
                <input type="text" class="form-control" name="keterangan" id="keterangan" placeholder="Keterangan">
            </div>
            <div class="form-group">
                <label for="lokasiId">Lokasi</label>
                <select class="form-control" name="lokasiId" id="lokasiId">
                    <?php foreach ($lokasis->data as $lokasi) { ?>
                        <option value="<?php echo $lokasi->id ?>"><?php echo $lokasi->namaLokasi ?></option>
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
                    url: '<?php echo API_URL ?>proyek',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(dataJson),
                    success: function(response) {
                        alert('Data berhasil disimpan');
                        window.location.href = '<?php echo BASE_URL ?>';
                    },
                    error: function(response) {
                        alert('Data gagal disimpan');
                        console.log(response);
                    }
                });
            });
        });
    }
</script>