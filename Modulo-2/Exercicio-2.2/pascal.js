function triangulodePascal (quantidade) {
    if (quantidade == 0) return console.log("");
    if (quantidade == 1) return console.log([quantidade]);

    let array1 = [1], array2 = [1, 1]; // nome=array1, propriedade=endereço, tempo=execução
    console.log(array1);
    console.log(array2);

    let anterior = array2, array = [];
    for (let linha = 0; linha < quantidade-2; linha++) { // nome=for, propriedade=implementação, tempo=especificação/design
        array.unshift(1); // nome=unshift, propriedade=método, tempo=ligação
        for (let elemento = 0; elemento < anterior.length-1; elemento++) {
            // nome=anterior[elemento+1], propriedade=endereço da posição, tempo=execução
            if (anterior[elemento+1] != NaN) { // nome=+, propriedade=semântica, tempo=compilação
                let valor = anterior[elemento] + anterior[elemento+1];
                array.push(valor);
            }
        }
        array.push(1);
        console.log(array);
        anterior = array;
        array = [];
    }
}

triangulodePascal(8);