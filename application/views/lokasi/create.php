<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Tambah Lokasi</h2>
                </div>
            </div>
        </div>
        <form id="lokasi-create">
            <div class="form-group">
                <label for="lokasi">Nama Lokasi</label>
                <input type="text" class="form-control" name="lokasi" id="lokasi" placeholder="Nama Lokasi">
            </div>
            <div class="form-group">
                <label for="negara">Negara</label>
                <input type="text" class="form-control" name="negara" id="negara" placeholder="Negara">
            </div>
            <div class="form-group">
                <label for="provinsi">Provinsi</label>
                <input type="text" class="form-control" name="provinsi" id="provinsi" placeholder="Provinsi">
            </div>
            <div class="form-group">
                <label for="kota">Kota</label>
                <input type="text" class="form-control" name="kota" id="kota" placeholder="Kota">
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
                    namaLokasi: $('#lokasi').val(),
                    negara: $('#negara').val(),
                    provinsi: $('#provinsi').val(),
                    kota: $('#kota').val()
                };

                $.ajax({
                    url: '<?php echo API_URL ?>lokasi',
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