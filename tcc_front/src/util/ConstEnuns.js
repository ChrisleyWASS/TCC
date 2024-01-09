export function getEnum(type, value){
    return enuns[type][value];
}
  
const enuns = {
    tipo_pessoa: {
        F: 'Física',
        J: 'Jurídica',
        E: 'Extrangeira'
    },

    phone_type: {
        RE: 'Residencial',
        CM: 'Comercial',
        PE: 'Pessoal',
        FI: 'Financeiro',
        CO: 'Compras',
        VE: 'Vendas',
        CE: 'Celular'
    },

    tipo_email: {
        CM: 'Comercial',
        PE: 'Pessoal',
        FI: 'Financeiro',
        CO: 'Comercial',
        VE: 'Vendas'
    },

    finalidade_produto: {
        TI00: 'Mercadoria para revenda',
        TI01: 'Matéria-prima',
        TI02: 'Embalabem',
        TI03: 'Produto em processo',
        TI04: 'Produto acabado',
        TI05: 'SubProduto',
        TI06: 'Produto intermediário',
        TI07: 'Material de uso e consumo',
        TI08: 'Ativo imobilizado',
        TI09: 'Serviços',
        TI10: 'Outros insumos',
        TI99: 'Outras'
    },

    tipo_operacao_dfe: {
        E: 'Entrada',
        S: 'Saída'
    },

    tipo_pagamento_nfe: {
        TP01: 'Dinheiro',
        TP02: 'Cheque',
        TP03: 'Cartão de Crédito',
        TP04: 'Cartão de Débito',
        TP05: 'Crédito Loja',
        TP10: 'Vale Alimentação',
        TP11: 'Vale Refeição',
        TP12: 'Vale Presente',
        TP13: 'Vale Combustível',
        TP14: 'Duplicata Mercantil',
        TP15: 'Boleto Bancário',
        TP99: 'Outros',
    },

    tipo_operacao_fator_conversao: {
        M: 'Multiplicação' ,
        D: 'Divisão' ,
    },
    true_false: {
        true: 'Sim' ,
        false: 'Não' ,
    },
    orca_tipo_pagamento: {
        TP01: 'Dinheiro',
        TP03: 'Cartão de Crédito',
        TP04: 'Cartão de Débito',
        TP05: 'Crédito Loja',
        TP02: 'Cheque',
        TP10: 'Vale Alimentação',
        TP11: 'Vale Refeição',
        TP12: 'Vale Presente',
        TP13: 'Vale Combustível',
        TP15: 'Boleto Bancário',
        TP16: 'Depósito Bancário',
        TP17: 'Pagamento Instantâneo (PIX)',
        TP18: 'Transferência bancária, Carteira Digital',
        TP19: 'Programa de fidelidade, Cashback, Crédito Virtual',
        TP90: 'Sem pagamento',
        TP99: 'Outros',
    },
    orca_tipo_indicador:  {
        IP0: 'A vista',
        IP1: 'A prazo'
    },
    orca_tipo_situacao: {
       AB: 'Aberto',
       FE: 'Fechado',
       CA: 'Cancelado',
       AR: 'Arquivado',
       PF: 'Pendente de Faturamento'
    },
}