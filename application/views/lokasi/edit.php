<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Edit Lokasi</h2>
                </div>
            </div>
        </div>
        <form id="lokasi-create">
            <div class="form-group">
                <label for="lokasi">Nama Lokasi</label>
                <input type="text" class="form-control" name="lokasi" id="lokasi" placeholder="Nama Lokasi" value="<?php echo $lokasi->data->namaLokasi ?>">
            </div>
            <div class="form-group">
                <label for="negara">Negara</label>
                <input type="text" class="form-control" name="negara" id="negara" placeholder="Negara" value="<?php echo $lokasi->data->negara ?>">
            </div>
            <div class="form-group">
                <label for="provinsi">Provinsi</label>
                <input type="text" class="form-control" name="provinsi" id="provinsi" placeholder="Provinsi" value="<?php echo $lokasi->data->provinsi ?>">
            </div>
            <div class="form-group">
                <label for="kota">Kota</label>
                <input type="text" class="form-control" name="kota" id="kota" placeholder="Kota" value="<?php echo $lokasi->data->kota ?>">
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
                    url: '<?php echo API_URL ?>lokasi/<?php echo $lokasi->data->id ?>',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(dataJson),
                    success: function(response) {
                        alert('Data berhasil diperbaharuhi');
                        window.location.href = '<?php echo BASE_URL ?>';
                    },
                    error: function(response) {
                        alert('Data gagal diperbaharuhi');
                        console.log(response);
                    }
                });
            });
        });
    }
</script>