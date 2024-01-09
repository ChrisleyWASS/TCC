<template>
    <div class="c-app my-app flex-row">
        <CContainer>
            <b-button-group>
                <b-button 
                    v-show="etapa != 1" 
                    @click="back()" 
                    class="btn_just_icon"                     
                    v-b-tooltip.hover title="Etapa Anterior"
                    style="color:#7144dd;"
                    ><b-icon icon="arrow-left-square" aria-hidden="true"></b-icon>
                </b-button>
                <b-button
                    @click="openModalInfo()" 
                    class="btn_just_icon" 
                    style="color:#768ddf;"
                    ><b-icon icon="question-square" aria-hidden="true"></b-icon>
                </b-button>
                <b-button
                    @click="openModalStatus()" 
                    class="btn_just_icon" 
                    style="color:#609b33;"
                    ><b-icon icon="table" aria-hidden="true"></b-icon>
                </b-button>
            </b-button-group>
            <b-progress :max="max" animated>
                <b-progress-bar :value="etapa" variant="info">
                    <span><strong>{{ etapa }} / {{ max }}</strong></span>
                </b-progress-bar>
            </b-progress>
            <CRow class="justify-content-center">
                <CCol v-if="etapa == 1">
                    <SelectRaca :prop_choseEspRacEtnia="selectEspRacEtnia">
                    </SelectRaca>
                </CCol>
                <CCol v-if="etapa == 2">
                    <SelectQualidade :prop_choseQualidade="selectQualidade">
                    </SelectQualidade>
                </CCol>
                <CCol v-if="etapa == 3">
                    <SelectDefeito :prop_choseDefeito="selectDefeito">
                    </SelectDefeito>
                </CCol>
                <CCol v-if="etapa == 4">
                    <SelectTrein :prop_choseTrn="selectTreinamento">
                    </SelectTrein>
                </CCol>
                <CCol v-if="etapa == 5">
                    <SelectCon :prop_choseCon="selectConhecimento">
                    </SelectCon>
                </CCol>
                <CCol v-if="etapa == 6">
                    <FinalizaPersonagem
                    :prop_Especie="chosedEspecie"
                    :prop_Raca="chosedRaca"
                    :prop_Etnia="chosedEtnia"
                    :prop_Qualidade="chosedQualidade"
                    :prop_Defeito="chosedDefeito"
                    :prop_Trn1="chosedTrn1"
                    :prop_Trn2="chosedTrn2"
                    :prop_Trn3="chosedTrn3" 
                    :prop_Con="chosedCon"
                    :prop_Chosed_Status="chosed_status"
                    :prop_Fields="fields"
                    >                   
                    </FinalizaPersonagem>
                </CCol>
                
                <!-- Outras etapas da crição -->
            </CRow>
        </CContainer>
        <b-modal id="modal-status" hide-footer hide-header  size="xl" class="my-modal-body">
            <capstable 
            :prop_textHover="'Relação das capacidades do personagem'"
            :prop_items="chosed_status"
            :prop_fields="fields"
            >
            </capstable>
        </b-modal>

        <b-modal id="modal-info" hide-footer hide-header  size="md" style="padding: 40px;">
            <div v-if="etapa == 1" >
                <h4>Informações da etapa 1</h4>
                <p> Nessa etapa é preciso definir a espécie, raça e etnia de nascimento do personagem, 
                    o que define seu conjunto incial de capacidades e aparência, conforme o padrão do seu povo.
                    Através da descrição das espécies e raças é possível compreender quais traços anatômicos e comportamentais
                    justificam a conjuntura de pontos de capacidade obtidos nessa etapa. 
                </p>
                <p> A espécie estabelece os principais aspectos da anatomia e características de um personagem, 
                    portanto, as espéies possuem maior diferença entre si e definem a maior parte dos pontos iniciais.
                </p>
                <p>
                   As raças são subdivisões da espécie, portanto, membros de uma mesma espécie, mas de raças diferentes, 
                   possuem muito em comun, porém, com algumas características anatomicas distintas. Portanto,
                   a escolha da raça cria variações da espécie, afetando algumas capacidades e aspectos da aparência.
                </p>
                <p>
                   Já as etnias são variações sociais e culturais dentro de uma mesma raça, 
                   geralmente definindo aspectos regionais comuns, como língua, religião, costumes, etc. 
                   As diferenças anatomicas entre etnias de uma mesma raça são insuficientes para afetar 
                   os pontos de capacidade, definindo apenas detalhes da aparência, como alguns 
                   traços, cores de pele, tipos cabelo, etc.                    
                </p>                
            </div>
            <div v-if="etapa == 2" >
                <h4>Informações da etapa 2</h4>
                <p>Qualidades expressam aptidões físicas e/ou comportamentais individuais, 
                   indicando individualidades do personagem, como tamanho, sociabilidade, capacidade de concentração etc.
                   Dessa forma, apesar de sua espécie, raça e etnia de origem, todo personagem possui suas próprias características.
                </p>
                <p>
                   Tais características costumam ter origem natural, como uma aptidão ou característica comportamental 
                   manifestada dêsde a infância, ou algum traço físico característico da família.Também existem capacidades aduiridas, 
                   decorrentes do estilo de vida, como consequência do trabalho, condições de vida e outros aspectos da vivência
                </p>                
            </div>
            <div v-if="etapa == 3" >
                <h4>Informações da etapa 3</h4>
                <p>Defeitos expressam limitações físicas e/ou comportamentais particulares, indicando características desvantajosas individuais.
                   Essas inabilidades e inaptidões podem reduzir ou neutralizar capacidades da espécie ou raça, ou ainda
                   reforçar vulnerabilidades características de um povo.
                </p>    
                <p>Tal como as qualidades, os defeitos podem ter diversas origens, sejam naturais, como tendências familiares negativas, 
                   inaptidões natas ou limitações intelectuais, ou adquiridas através de maus hábitos, aprendizado, traumas, falta de prática, etc.</p>            
            </div>
            <div v-if="etapa == 4" >
                <h4>Informações da etapa 4</h4>
                <p>A etapa de seleção dos treinamentos indica capacidades e/ou habilidades especiais obtidas,
                    exclusivamente, pelos esforços do personagem, gerlmente por meio de estudos e prática.
                </p>    
                <p>
                    Para definir os treinamentos é preciso pensar na ocupação do personagem, como ele ganha a vida,
                    no que ele é bom, quais habilidades ele mais utiliza e pratica. Naturalmente, 
                    é relevante que os treinamentos do personagem se enquadrem na história de origem do mesmo, 
                   uma vez que costumam expressar sua ocupação atual.
                </p>
            </div>
            <div v-if="etapa == 5" >
                <h4>Informações da etapa 5</h4>
                <p>Uma vez que o as capacidades básicas do personagem estão definidas, 
                    é preciso pensar sobre como elas foram adquiridas. Nessa etapa é necessário formular                    
                    os principais eventos narrativos que compõe a história prévia do personagem,
                    e encaixar esses eventos em 3 etapas principais.
                </p>
                <p>A primeira etapa é a origem, onde se define onde e sob quais 
                    circunstâncias o personagem nasceu e cresceu, estilo de vida durante a infância e juventude,
                    entre outros aspectos da primeira fase de sua vida. 
                </p>
                <p>A segunda etapa é intermediaria entre a origem e sua fase atual, e diz respeito ao desenvolvimento do personagem. 
                    Geralmente, é nessa fase que ele aperfeiçoa seus conhecimentos relacionados a origem,
                    ou se adapta a alguma mudança em seu estilo de vida, desenvolvendo novas habilidades.
                </p>
                <p>A terceira etapa diz respeito a ocupação atual do personagem, podendo ou não estar relacionada ao que
                   foi aprendido na origem e desenvolvimento. Dessa forma, a tereira etapa deve ser pensada com base no
                   presente, expressando os conhecimentos e habilidades que o personagem utiliza com frequência.
                </p> 
            </div>
        </b-modal>
    </div>
</template>


<script>
import FinalizaPersonagem from '@/components/CriaPersonagem/Fechamento/finaliza'
import SelectRaca from '@/components/CriaPersonagem/Raca/SelectRaca'
import SelectQualidade from '@/components/CriaPersonagem/Caracteristica/SelectQualidade'
import SelectDefeito from '@/components/CriaPersonagem/Caracteristica/SelectDefeito'
import SelectTrein from '@/components/CriaPersonagem/Treinamento/SelectTreinamento'
import SelectCon from '@/components/CriaPersonagem/Conhecimento/SelectConhecimento'
import capUtil from "@/util/Capacidades";
import capstable from "@/components/tables/CapsTable";

export default {
    name: 'Lista',
    components: {
        FinalizaPersonagem,
        SelectRaca,
        SelectQualidade,
        SelectDefeito,
        SelectTrein,
        SelectCon,
        capstable
    },
    data() {
        return {
            etapa: 1,
            max: 6,
            etapaText: "",
            chosed_status: [],
            chosedEspecie: {},
            chosedRaca: {},
            chosedEtnia: {},
            chosedQualidade: {},
            chosedDefeito: {},
            chosedTrn1: {},
            chosedTrn2: {},
            chosedTrn3: {},
            chosedCon: [],
            fields: [
                {
                    key: 'capacidade',
                    width: '25px',
                    class: 'tb-coluna-principal'
                },
                {
                    key: 'Especie',
                    variant: 'secondary',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Raça',
                    variant: 'secondary',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Qualidade',
                    variant: 'secondary',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Defeito',
                    variant: 'secondary',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Treinamento_1',
                    label: 'Tr.1',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Treinamento_2',
                    label: 'Tr.2',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Treinamento_3',
                    label: 'Tr.3',
                    class: 'tb-coluna',                    
                    tdClass: this.capValueColor
                },
                {
                    key: 'Personagem',
                    sortable: true,
                    class: 'tb-coluna-info ',                    
                    tdClass: this.capValueColor
                },
            ],
        }
    },

    created: function () {
        this.inicializaChosed(this.chosedEspecie)
        this.inicializaChosed(this.chosedRaca)
        this.inicializaChosed(this.chosedQualidade)
        this.inicializaChosed(this.chosedDefeito)
        this.inicializaChosed(this.chosedTrn1)
        this.inicializaChosed(this.chosedTrn2)
        this.inicializaChosed(this.chosedTrn3)
    },
    
    methods: {

        back() {
            if (this.etapa > 1) {
                this.etapa = this.etapa - 1
            }
            if(this.etapa == 1){
                this.inicializaChosed(this.chosedEspecie)
                this.inicializaChosed(this.chosedRaca)
            } else if(this.etapa == 2){                
                this.inicializaChosed(this.chosedQualidade)
            } else if(this.etapa == 3){
                this.inicializaChosed(this.chosedDefeito)
            } else if(this.etapa == 4){
                this.inicializaChosed(this.chosedTrn1)
                this.inicializaChosed(this.chosedTrn2)
                this.inicializaChosed(this.chosedTrn3)
            }
        },

        selectEspRacEtnia(especie, raca, etnia) {
            this.chosedEspecie = especie;
            this.chosedRaca = raca;
            this.chosedEtnia = etnia;
            this.etapa = 2;
            this.updateStatus();
        },

        selectQualidade(qualidade) {
            this.chosedQualidade = qualidade;
            this.etapa = 3
            this.updateStatus();
        },

        selectDefeito(defeito) {
            this.chosedDefeito = defeito;
            this.etapa = 4
            this.updateStatus();
        },

        selectTreinamento(Trn1, Trn2, Trn3) {
            this.chosedTrn1 = Trn1;
            this.chosedTrn2 = Trn2;
            this.chosedTrn3 = Trn3;
            this.etapa = 5
            this.updateStatus();
        },

        selectConhecimento(con){            
            this.chosedCon = con;
            this.etapa = 6
        },

        openModalInfo(){
            this.$bvModal.show("modal-info");
        },

        openModalStatus(){
            this.updateStatus();
            this.$bvModal.show("modal-status");
        },

        inicializaChosed(objChosed){
            objChosed.nome = "";            
            objChosed.capacidades = capUtil.capsVazia();            
        },

        updateStatus(){
            this.chosed_status = capUtil.capsChosed(
                                this.chosedEspecie,
                                this.chosedRaca,
                                this.chosedQualidade,
                                this.chosedDefeito,
                                this.chosedTrn1,
                                this.chosedTrn2,
                                this.chosedTrn3);
        },

        capValueColor(value) {
            if(value == 0){
                return 'td-element-zero';
            } else if(value < 0){
                if(value < -2){
                    return 'td-element-vbad';
                } else {
                    return 'td-element-bad';
                }
            } else if(value > 0){
                if(value > 2){
                    return 'td-element-vgood';
                } else {
                    return 'td-element-good';
                }
            }            
        },

    }
}
</script>