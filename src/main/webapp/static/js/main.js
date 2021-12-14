// const categorySelect = document.getElementById("sort-category");
// const supplierSelect = document.getElementById("sort-supplier");
//
// categorySelect.addEventListener("change", handleSelection);
//
// function handleSelection(e) {
//     const value = e.target.value;
//     console.log(value);
// }

function addButton() {
    const addButtonList = document.getElementsByClassName("add-button");
    for (const addButton of addButtonList){
        addButton.addEventListener("click", () => {
            const id = addButton.id;
            postData(`/add-to-cart?id=${id}`);
        });
    }

    async function postData(url = '') {
        await fetch(url, {
            method: 'POST'
        });
    }
}

addButton();