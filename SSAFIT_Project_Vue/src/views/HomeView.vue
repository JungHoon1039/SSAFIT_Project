<template>
	<Header></Header>
	<div class="container">
		<Search></Search>
		<RecentVideo></RecentVideo>
		<SelectPart></SelectPart>
	</div>
</template>

<script setup>
	import Header from '../components/Header.vue';
	import Search from '../components/Search.vue';
	import RecentVideo from '../components/RecentVideo.vue';
	import SelectPart from '../components/SelectPart.vue';
</script>

<style scoped>

</style>