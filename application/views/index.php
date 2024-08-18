<div class="container">
	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-6">
					<h2>Lokasi</h2>
				</div>
				<div class="col-sm-6">
					<a href="lokasi/create" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Tambah Lokasi</span></a>
				</div>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Nama Lokasi</th>
					<th>Negara</th>
					<th>Provinsi</th>
					<th>Kota</th>
					<th>Aksi</th>
				</tr>
			</thead>
			<tbody>
				<?php
				foreach ($lokasis->data as $lokasi) {
				?>

					<tr>
						<td><?php echo $lokasi->namaLokasi ?></td>
						<td><?php echo $lokasi->negara ?></td>
						<td><?php echo $lokasi->provinsi ?></td>
						<td><?php echo $lokasi->kota ?></td>
						<td>
							<a href="lokasi/edit/<?php echo $lokasi->id ?>" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="lokasi/delete/<?php echo $lokasi->id ?>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
				<?php
				}
				?>
			</tbody>
		</table>
	</div>

	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-6">
					<h2>Proyek</h2>
				</div>
				<div class="col-sm-6">
					<a href="proyek/create" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Tambah Proyek</span></a>
				</div>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Nama Proyek</th>
					<th>Client</th>
					<th>Tanggal Mulai</th>
					<th>Tanggal Selesai</th>
					<th>Pimpinan Proyek</th>
					<th>Keterangan</th>
					<th>Nama Lokasi</th>
					<th>Aksi</th>
				</tr>
			</thead>
			<tbody>
				<?php
				foreach ($proyeks->data as $proyek) {
				?>

					<tr>
						<td><?php echo $proyek->namaProyek ?></td>
						<td><?php echo $proyek->client ?></td>
						<td><?php echo date("F j, Y, g:i a", strtotime($proyek->tglMulai)); ?></td>
						<td><?php echo date("F j, Y, g:i a", strtotime($proyek->tglSelesai)); ?></td>
						<td><?php echo $proyek->pimpinanProyek ?></td>
						<td><?php echo $proyek->keterangan ?></td>
						<td><?php echo $proyek->lokasis[0]->namaLokasi ?></td>
						<td>
							<a href="proyek/edit/<?php echo $proyek->id ?>" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="proyek/delete/<?php echo $proyek->id ?>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
				<?php
				}
				?>
			</tbody>
		</table>
	</div>
</div>