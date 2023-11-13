<template>
		<div style="width: 100%; padding: 10px; border-radius: 8px; " class="d-flex align-items-center shadow-sm mb-4">
			<span class="material-symbols-outlined">search</span>
			<div style="flex-grow: 1;  margin-left: 10px;">
				<input style=" width: 100%; border: none; background-color: transparent; margin: 6px 2px 6px 2px; padding: 2px;" list="datalistOptions" placeholder="운동 제목 검색">

			</div>
			<datalist id="datalistOptions">
				<option value="상체"></option>
				<option value="하체"></option>
				<option value="어깨"></option>
				<option value="가슴"></option>
				<option value="삼두"></option>
			</datalist>
		</div>
</template>

<script setup>

</script>

<style scoped>

</style>