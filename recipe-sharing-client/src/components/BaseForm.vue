<template>
    <div style="background-color: white; padding: 2rem;">
        <VForm v-if="formData">
            <VCol v-for="(value, key) in formInputs" :key="key">
                <!-- <VRow v-if="isNextRowCol()">
                    <VCol>
                        <v-text-field v-if="typeof value === 'string' || typeof value === 'number'" :label="key"
                            v-model="formData[key]" />
                        <v-select v-if="(typeof value === 'object') && selectLists" :label="key"
                            :items="selectLists[key].map((x: any) => x.text)" v-model="formData[key]" />
                    </VCol>
                </VRow> -->
                <!-- <VCol> -->
                    <v-text-field v-if="typeof value === 'string' || typeof value === 'number'" :label="key"
                        v-model="formData[key]" />
                    <v-select v-if="(typeof value === 'object') && selectLists" :label="key"
                        :items="selectLists[key].map((x: any) => x.text)" v-model="formData[key]" />
                <!-- </VCol> -->
                </VCol>

        </VForm>
        <p v-else>Loading form data...</p>
        <VRow>
            <VCol style="display: flex; justify-content: end;">
                <v-btn color="green" prepend-icon="mdi-check">Save</v-btn>
            </VCol>
        </VRow>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const props = defineProps({
    formData: Object,
    selectLists: Object,
    columnsPerRow: Number,
});

const formData = ref(props.formData);
const formInputs = ref(filterIdFromInputs());
const selectLists = ref(props.selectLists);
const columnsPerRow = ref(props.columnsPerRow ? props.columnsPerRow : 1);
var colCounter = ref(0);

//#region Methods
function filterIdFromInputs() {
    let tempFormInputs = formData.value;
    if (tempFormInputs && tempFormInputs.id) {
        delete tempFormInputs.id;
    }
    return tempFormInputs;
}

function isNextRowCol() {
    let colCounterCurr = colCounter.value;
    let colsPerRowCurr = columnsPerRow.value;
    
    if (colCounterCurr >= colsPerRowCurr) {
        colCounter.value = 0;
        return true;
    }
    else {
        colCounter.value = colCounter.value + 1;
        return false;
    }
}
//#endregion
</script>
