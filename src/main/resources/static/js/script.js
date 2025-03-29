document.addEventListener('DOMContentLoaded', function () {
    const kuupaevFilter = document.getElementById('kuupäev');
    const lennuaegFilter = document.getElementById('lennuaeg');
    const sihtkohtFilter = document.getElementById('sihtkoht');
    const filterButton = document.getElementById('filterButton');
    const tbody = table.querySelector('tbody');


    function täiendaRippmenuu() {
        const kuupaevad = new Set();
        const lennuajad = new Set();
        const sihtkohad = new Set();

        lennud.forEach(lend => {
            kuupaevad.add(lend.kuupaev);
            lennuajad.add(lend.lennuaeg);
            sihtkohad.add(lend.sihtkoht);
        });

        kuupaevad.forEach(kuupaev => {
            const option = document.createElement('option');
            option.value = kuupaev;
            option.textContent = kuupaev;
            kuupaevFilter.appendChild(option);
        });

        lennuajad.forEach(lennuaeg => {
            const option = document.createElement('option');
            option.value = lennuaeg;
            option.textContent = lennuaeg;
            lennuaegFilter.appendChild(option);
        });

        sihtkohad.forEach(sihtkoht => {
            const option = document.createElement('option');
            option.value = sihtkoht;
            option.textContent = sihtkoht;
            sihtkohtFilter.appendChild(option);
        });
    }

    function renderTable(filteredFlights) {
        tbody.innerHTML = '';
        filteredFlights.forEach(lend => {
            const row = document.createElement('tr');
            Object.values(lend).forEach(väärtus => {
                const cell = document.createElement('td');
                cell.textContent = väärtus;
                row.appendChild(cell);
            });
            tbody.appendChild(row);
        });
    }

    function filterFlights() {
        const kuupaevVäärtus = kuupaevFilter.value;
        const lennuaegVäärtus = lennuaegFilter.value;
        const sihtkohtVäärtus = sihtkohtFilter.value;

        const filteredFlights = lennud.filter(lend => {
            const kuupaevMatch = !kuupaevVäärtus || lend.kuupaev === kuupaevVäärtus;
            const lennuaegMatch = !lennuaegVäärtus || lend.lennuaeg === lennuaegVäärtus;
            const sihtkohtMatch = !sihtkohtVäärtus || lend.sihtkoht === sihtkohtVäärtus;
            return kuupaevMatch && lennuaegMatch && sihtkohtMatch;
        });

        renderTable(filteredFlights);
    }

    täiendaRippmenuu();
    renderTable(lennud);

    filterButton.addEventListener('click', function () {
        filterFlights();
    });
});
let valitudIste = null;

function valiIste(istmeElement) {
    if (valitudIste) {
        valitudIste.classList.remove('valitud');
    }

    istmeElement.classList.add('valitud');
    valitudIste = istmeElement;

    const istmeNumber = istmeElement.dataset.istmeNumber;
    const vaba = istmeElement.dataset.vaba === 'true';
    const jalaruum = istmeElement.dataset.jalaruum === 'true';
    const aken = istmeElement.dataset.aken === 'true';
    const väljapääs = istmeElement.dataset.väljapääs === 'true';

    document.getElementById('istmeNumber').textContent = `Istme Number: ${istmeNumber}`;
    document.getElementById('vaba').textContent = `Vaba: ${vaba ? 'Jah' : 'Ei'}`;
    document.getElementById('jalaruum').textContent = `Jalaruum: ${jalaruum ? 'Jah' : 'Ei'}`;
    document.getElementById('aken').textContent = `Aken: ${aken ? 'Jah' : 'Ei'}`;
    document.getElementById('väljapääs').textContent = `Väljapääs: ${väljapääs ? 'Jah' : 'Ei'}`;
    document.getElementById('istmeDetailid').style.display = 'block';
}

function sulgeDetailid() {
    document.getElementById('istmeDetailid').style.display = 'none';
}

function filterSeats() {
    const jalaruumFilter = document.getElementById('jalaruumFilter').checked;
    const akenFilter = document.getElementById('akenFilter').checked;
    const väljapääsFilter = document.getElementById('väljapääsFilter').checked;
    const kaksInimestFilter = document.getElementById('kaksInimestFilter').checked;

    document.querySelectorAll('td[data-istme-number]').forEach(iste => {
        iste.classList.remove('filtreeritud');
    });
    if (!jalaruumFilter && !akenFilter && !väljapääsFilter && !kaksInimestFilter) {
        return;
    }

    document.querySelectorAll('td[data-istme-number]').forEach(istmeElement => {
        const istmeNumber = istmeElement.dataset.istmeNumber;
        const vaba = istmeElement.dataset.vaba === 'true';
        const jalaruum = istmeElement.dataset.jalaruum === 'true';
        const aken = istmeElement.dataset.aken === 'true';
        const väljapääs = istmeElement.dataset.väljapääs === 'true';

        let meetsBasicCriteria = vaba &&
            (!jalaruumFilter || jalaruum) &&
            (!akenFilter || aken) &&
            (!väljapääsFilter || väljapääs);

        if (!meetsBasicCriteria) {
            return;
        }
        // ChatGPT kasutus: kahe inimese filter.
        if (kaksInimestFilter) {
            const col = istmeNumber.charAt(0);
            const row = istmeNumber.slice(1);

            const prevCol = String.fromCharCode(col.charCodeAt(0) - 1);
            const nextCol = String.fromCharCode(col.charCodeAt(0) + 1);

            const prevSeat = `${prevCol}${row}`;
            const nextSeat = `${nextCol}${row}`;

            const prevSeatElement = document.querySelector(`td[data-istme-number="${prevSeat}"]`);
            const nextSeatElement = document.querySelector(`td[data-istme-number="${nextSeat}"]`);

            const prevAvailable = prevSeatElement && prevSeatElement.dataset.vaba === 'true';
            const nextAvailable = nextSeatElement && nextSeatElement.dataset.vaba === 'true';

            if (akenFilter && aken) {
                if (prevAvailable) {
                    prevSeatElement.classList.add('filtreeritud');
                    istmeElement.classList.add('filtreeritud');
                }
                if (nextAvailable) {
                    nextSeatElement.classList.add('filtreeritud');
                    istmeElement.classList.add('filtreeritud');
                }
            }
            else if (prevAvailable || nextAvailable) {
                istmeElement.classList.add('filtreeritud');
                if (prevAvailable) prevSeatElement.classList.add('filtreeritud');
                if (nextAvailable) nextSeatElement.classList.add('filtreeritud');
            }

            else {
                return;
            }
        } else {

            istmeElement.classList.add('filtreeritud');
        }
    });
}
function tagasiLennud() {
    window.location.href = "/lennud";
}