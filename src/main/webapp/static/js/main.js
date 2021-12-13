const categorySelect = document.getElementById("sort-category");
const supplierSelect = document.getElementById("sort-supplier");

categorySelect.addEventListener("change", handleSelection);

function handleSelection(e) {
    const value = e.target.value;
    console.log(value);
}