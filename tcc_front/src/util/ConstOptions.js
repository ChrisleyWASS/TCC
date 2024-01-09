export const tipoPessoaOptions = [
    { value: 'F', text: 'Física'},
    { value: 'J', text: 'Jurídica'},
    { value: 'E', text: 'Extrangeira'}
]

export const tipoPessoaEmpresaOptions = [
    { value: 'F', text: 'Física'},
    { value: 'J', text: 'Jurídica'}
]

export const tipoSituacaoVendaOptions = [
    { value: 'LI', text: 'Liberado' },
    { value: 'BL', text: 'Bloqueado' },
    { value: 'PR', text: 'Protestado' },
    { value: 'RE', text: 'Restrição' }
]

export const estadoOptions = [
    { value: '', text: "Selecione a UF" },      
    { value: 1, text: "AC" },
    { value: 2, text: "AL" },
    { value: 3, text: "AP" },
    { value: 4, text: "AM" },
    { value: 5, text: "BA" },
    { value: 6, text: "CE" },
    { value: 7, text: "DF" },
    { value: 8, text: "ES" },
    { value: 9, text: "GO" },
    { value: 10, text: "MA" },
    { value: 11, text: "MT" },
    { value: 12, text: "MS" },
    { value: 13, text: "MG" },
    { value: 14, text: "PA" },
    { value: 15, text: "PB" },
    { value: 16, text: "PR" },
    { value: 17, text: "PE" },
    { value: 18, text: "PI" },
    { value: 19, text: "RJ" },
    { value: 20, text: "RN" },
    { value: 21, text: "RS" },
    { value: 22, text: "RO" },
    { value: 23, text: "RR" },
    { value: 24, text: "SC" },
    { value: 25, text: "SP" },
    { value: 26, text: "SE" },
    { value: 27, text: "TO" },
    { value: 28, text: "EX" }
]

export const tipoPessoaTelefoneOptions = [
    { value: 'RE', text: 'Residencial' },
    { value: 'CM', text: 'Comercial' },
    { value: 'PE', text: 'Pessoal' },
    { value: 'FI', text: 'Financeiro' },
    { value: 'CO', text: 'Compas' },
    { value: 'VE', text: 'Vendas' },
    { value: 'CE', text: 'Celular' },  
]

export const tipoPessoaEmailOptions = [
    { value: 'CM', text: 'Comercial' },
    { value: 'PE', text: 'Pessoal' },
    { value: 'FI', text: 'Financeiro' },
    { value: 'CO', text: 'Compas' },
    { value: 'VE', text: 'Vendas' },
]

export const produtoTipoOrigemOptions = [
    { value: 'PO0', text: 'Nacional' },
    { value: 'PO1', text: 'Estrangeira - Importação direta' },
    { value: 'PO2', text: 'Estrangeira - Adquirida no mercado interno' },
    { value: 'PO3', text: 'Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%' },
    { value: 'PO4', text: 'Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam as legislações citadas nos Ajustes' },
    { value: 'PO5', text: 'Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%' },
    { value: 'PO6', text: 'Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural' },
    { value: 'PO7', text: 'Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista da CAMEX e gás natural' },
    { value: 'PO8', text: 'Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70%' }
]

export const produtoTipoCfopOptions = [
    { value: 'N', text: 'Normal' },
    { value: 'L', text: 'Lubrificante' },
]

export const tipoRegimeEmpresaOptions = [
    { value: 'MEI', text: 'MEI'},
    { value: 'SN', text: 'Simples nacional'},
    { value: 'SNE', text: 'Simples nacional – excesso de sublimite de receita bruta'},
    { value: 'RN', text: 'Regime normal'}
]

export const produtoTipoFinalidadeOptions = [
    { value: 'TI00', text: 'Mercadoria para revenda'},
    { value: 'TI01', text: 'Matéria-prima'},
    { value: 'TI02', text: 'Embalabem'},
    { value: 'TI03', text: 'Produto em processo'},
    { value: 'TI04', text: 'Produto acabado'},
    { value: 'TI05', text: 'SubProduto'},
    { value: 'TI06', text: 'Produto intermediário'},
    { value: 'TI07', text: 'Material de uso e consumo'},
    { value: 'TI08', text: 'Ativo imobilizado'},
    { value: 'TI09', text: 'Serviços'},
    { value: 'TI10', text: 'Outros insumos'},
    { value: 'TI99', text: 'Outras'}
]

export const operacaoDFeTipoOptions = [
    { value: 'E', text: 'Entrada' },
    { value: 'S', text: 'Saída' },
]

export const tipoDocumentoNFeOptions = [
    { value: 'E', text: 'Entrada' },
    { value: 'S', text: 'Saída' },
]

export const tipoFinalidadeNFeOptions = [
    { value: 'N', text: 'Normal' },
    { value: 'R', text: 'Retorno / Devolução' },
    { value: 'A', text: 'Ajuste' },
]

export const tipoSituacaoNFeOptions = [
    { value: 'AU', text: 'Autorizada' },
    { value: 'CA', text: 'Cancelada' },
    { value: 'DE', text: 'Denegada' },
    { value: 'IN', text: 'Inutilizada' },
    { value: 'PE', text: 'Pendente de envio' },
]

export const tipoRegimeEspecialISSOptions = [
    { value: 'MM', text: 'Microempresa Municipal' },
    { value: 'ES', text: 'Estimativa' },
    { value: 'SP', text: 'Sociedade de Profissionais' },
    { value: 'CP', text: 'Cooperativa' },
    { value: 'MEI', text: 'Microempresário Individual (MEI)' },
    { value: 'EPP', text: 'Microempresário e Empresa de Pequeno Porte (ME/EPP)' },
]

export const tipoModalidadeFreteOptions = [
    { value: 'TMF0', text: 'Remetente (CIF)' },
    { value: 'TMF1', text: 'Destinatário / Remetente (FOB)' },
    { value: 'TMF2', text: 'Terceiros' },
    { value: 'TMF3', text: 'Próprio Remetente' },
    { value: 'TMF4', text: 'Próprio Destinatário' },
    { value: 'TMF9', text: 'Sem Frete' },
]

export const tipoVeiculoOptions = [
    { value: '', text: 'Selecione o tipo de veículo' },
    { value: 'TVC', text: 'Veículo' },
    { value: 'TVB', text: 'Vagão' },
    { value: 'TVV', text: 'Balsa' },    
]

export const tipoIndicadorPagamentoNFeOptions = [
    { value: 'TIP0', text: 'A vista' },
    { value: 'TIP1', text: 'A Prazo' },
]

export const tipoPagamentoNFeOptions = [
    { value: 'TP01', text: 'Dinheiro' },
    { value: 'TP02', text: 'Cheque' },
    { value: 'TP03', text: 'Cartão de Crédito' },
    { value: 'TP04', text: 'Cartão de Débito' },
    { value: 'TP05', text: 'Crédito Loja' },
    { value: 'TP10', text: 'Vale Alimentação' },
    { value: 'TP11', text: 'Vale Refeição' },
    { value: 'TP12', text: 'Vale Presente' },
    { value: 'TP13', text: 'Vale Combustível' },
    { value: 'TP14', text: 'Duplicata Mercantil' },
    { value: 'TP15', text: 'Boleto Bancário' },    
    { value: 'TP99', text: 'Outros' },
]

export const tipoBandeiraCartaoNFeOptions = [
    { value: 'TB01', text: 'Visa' },
    { value: 'TB02', text: 'Mastercard' },
    { value: 'TB03', text: 'American Express' },
    { value: 'TB04', text: 'Sorocred' },
    { value: 'TB05', text: 'Diners Club' },
    { value: 'TB06', text: 'Elo' },
    { value: 'TB07', text: 'Hipercard' },
    { value: 'TB08', text: 'Aura' },
    { value: 'TB09', text: 'Cabal' },
    { value: 'TB99', text: 'Outros' },
]

export const tipoIndicadorPagamentoOptions = [
    { value: 'V', text: 'A vista' },
    { value: 'P', text: 'A prazo' },
    { value: 'O', text: 'Outras' },
]

export const tipoFreteOptions = [
    { value: 'CFR', text: 'Contratação do Frete por conta do Remetente' },
    { value: 'CFD', text: 'Contratação do Frete por conta do Destinatário' },
    { value: 'CFT', text: 'Contratação do Frete por conta de Terceiros' },
    { value: 'TPR', text: 'Transporte Próprio por conta do Remetente' },
    { value: 'TPD', text: 'Transporte Próprio por conta do Destinatário' },
    { value: 'SOT', text: 'Sem Ocorrência de Transporte' },
]

export const tipoIndicadorFreteOptions = [
    { value: 'IF0', text: 'Por conta do emitente' },
    { value: 'IF1', text: 'Por conta do destinatário/remetente' },
    { value: 'IF2', text: 'Por conta de terceiros' },
    { value: 'IF9', text: 'Sem cobrança de frete' }
]

export const tipoUsuarioOptions = [
    { value: 'V', text: 'Vendedor' },
    { value: 'C', text: 'Caixa' },
    { value: 'G', text: 'Gerente' },
]

export const tipoSituacaoOrcamentoConsultaOptions = [
    { value: null, text: 'Todos' },
    { value: 'AB', text: 'Aberto' },
    { value: 'FE', text: 'Fechado' },
    { value: 'CA', text: 'Cancelado' },
    { value: 'AR', text: 'Arquivado' },
    { value: 'PF', text: 'Pendente de Faturamento' },
]

export const tipoModalidadeBaseCalculoICMSOptions = [
    { value: 'MVA', text: 'Margem Valor Agregado (%)' },
    { value: 'PV', text: 'Pauta (valor)' },
    { value: 'PTM', text: 'Preço Tabelado Máximo (valor)' },
    { value: 'VO', text: 'Valor da Operação' },    
]

export const tipoModalidadeBaseCalculoICMSSTOptions = [
    { value: 'PTMS', text: 'Preço tabelado ou máximo  sugerido' },
    { value: 'LNG', text: 'Lista Negativa (valor)' },
    { value: 'LPS', text: 'Lista Positiva (valor)' },
    { value: 'LNE', text: 'Lista Neutra (valor)' },    
    { value: 'MVA', text: 'Margem Valor Agregado (%)' },    
    { value: 'PV', text: 'Pauta (valor)' },    
    { value: 'VO', text: 'Valor da Operação' },    
]

export const tipoDesoneracaoICMSOptions = [
    { value: 'TAXI', text: 'Táxi' },
    { value: 'PA',   text: 'Produtor Agropecuário' },
    { value: 'FL',   text: 'Frotista/Locadora' },
    { value: 'DC',   text: 'Diplomático/Consular' },    
    { value: 'UMAO', text: 'Utilitários e Motocicletas da Amazônia Ocidental e Áreas de Livre Comércio (Resolução 714/88 e 790/94 – CONTRAN e suas alterações)' },    
    { value: 'SUFR', text: 'SUFRAMA' },    
    { value: 'VOP',  text: 'Venda a Órgãos Públicos' },    
    { value: 'OUTR', text: 'Outros' },
    { value: 'DFC',  text: 'Deficiente Condutor (Convênio ICMS 38/12)' },
    { value: 'DFNC', text: 'Deficiente Não Condutor (Convênio ICMS 38/12)' },
    { value: 'OFDA', text: 'Órgão de fomento e desenvolvimento agropecuário' },
    { value: 'SPF',  text: 'Solicitado pelo Fisco' },
]

export const tipoSituacaoAbertoFechadoOptions = [
    { value: 'A', text: 'Aberto' },
    { value: 'F', text: 'Fechado' },
]