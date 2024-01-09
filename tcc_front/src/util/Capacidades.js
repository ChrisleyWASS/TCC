export default {

    capsVazia() {
        let caps = []
        caps.FRC = 0
        caps.MOB = 0
        caps.RES = 0
        caps.AGL = 0
        caps.DSV = 0
        caps.STZ = 0
        caps.TNA = 0
        caps.IMD = 0
        caps.VIG = 0
        caps.RAZ = 0
        caps.ATN = 0
        caps.OBT = 0
        caps.CAR = 0
        caps.IMP = 0
        caps.RET = 0

        return caps
    },

    capsSoma(capsBase, capsAdd) {
        capsBase.FRC = capsBase.FRC + capsAdd.FRC
        capsBase.MOB = capsBase.MOB + capsAdd.MOB
        capsBase.RES = capsBase.RES + capsAdd.RES
        capsBase.AGL = capsBase.AGL + capsAdd.AGL
        capsBase.DSV = capsBase.DSV + capsAdd.DSV
        capsBase.STZ = capsBase.STZ + capsAdd.STZ
        capsBase.TNA = capsBase.TNA + capsAdd.TNA
        capsBase.IMD = capsBase.IMD + capsAdd.IMD
        capsBase.VIG = capsBase.VIG + capsAdd.VIG
        capsBase.RAZ = capsBase.RAZ + capsAdd.RAZ
        capsBase.ATN = capsBase.ATN + capsAdd.ATN
        capsBase.OBT = capsBase.OBT + capsAdd.OBT
        capsBase.CAR = capsBase.CAR + capsAdd.CAR
        capsBase.IMP = capsBase.IMP + capsAdd.IMP
        capsBase.RET = capsBase.RET + capsAdd.RET

        return capsBase;
    },

    capsToArray(capsBase){
        let caps = []
        caps[0] = capsBase.FRC
        caps[1] = capsBase.MOB
        caps[2] = capsBase.RES
        caps[3] = capsBase.AGL
        caps[4] = capsBase.DSV
        caps[5] = capsBase.STZ
        caps[6] = capsBase.TNA
        caps[7] = capsBase.IMD
        caps[8] = capsBase.VIG
        caps[9] = capsBase.RAZ
        caps[10] = capsBase.ATN
        caps[11] = capsBase.OBT
        caps[12] = capsBase.CAR
        caps[13] = capsBase.IMP
        caps[14] = capsBase.RET

        return caps;
    },

    capsClean(capsBase) {

        let capDisplay = []

        if (capsBase.FRC > 0) {
            capDisplay[0] = { capacidade: 'FORÇA', sigla: 'FRC', valor: '+' + capsBase.FRC }
        } else if (capsBase.FRC < 0) {
            capDisplay[0] = { capacidade: 'FORÇA', sigla: 'FRC', valor: capsBase.FRC }
        }

        if (capsBase.MOB > 0) {
            capDisplay[1] = { capacidade: 'MOBILIDADE', sigla: 'MOB', valor: '+' + capsBase.MOB }
        } else if (capsBase.MOB < 0) {
            capDisplay[1] = { capacidade: 'MOBILIDADE', sigla: 'MOB', valor: capsBase.MOB }
        }

        if (capsBase.RES > 0) {
            capDisplay[2] = { capacidade: 'RESISTÊNCIA', sigla: 'RES', valor: '+' + capsBase.RES }
        } else if (capsBase.RES < 0) {
            capDisplay[2] = { capacidade: 'RESISTÊNCIA', sigla: 'RES', valor: capsBase.RES }
        }

        if (capsBase.AGL > 0) {
            capDisplay[3] = { capacidade: 'AGILIDADE', sigla: 'AGL', valor: '+' + capsBase.AGL }
        } else if (capsBase.AGL < 0) {
            capDisplay[3] = { capacidade: 'AGILIDADE', sigla: 'AGL', valor: capsBase.AGL }
        }

        if (capsBase.STZ > 0) {
            capDisplay[4] = { capacidade: 'SUTILEZA', sigla: 'STZ', valor: '+' + capsBase.STZ }
        } else if (capsBase.STZ < 0) {
            capDisplay[4] = { capacidade: 'SUTILEZA', sigla: 'STZ', valor: capsBase.STZ }
        }

        if (capsBase.DSV > 0) {
            capDisplay[5] = { capacidade: 'DESENVOLTURA', sigla: 'DSV', valor: '+' + capsBase.DSV }
        } else if (capsBase.DSV < 0) {
            capDisplay[5] = { capacidade: 'DESENVOLTURA', sigla: 'DSV', valor: capsBase.DSV }
        }

        if (capsBase.TNA > 0) {
            capDisplay[6] = { capacidade: 'TENACIDADE', sigla: 'TNA', valor: '+' + capsBase.TNA }
        } else if (capsBase.TNA < 0) {
            capDisplay[6] = { capacidade: 'TENACIDADE', sigla: 'TNA', valor: capsBase.TNA }
        }

        if (capsBase.VIG > 0) {
            capDisplay[7] = { capacidade: 'VIGOR', sigla: 'VIG', valor: '+' + capsBase.VIG }
        } else if (capsBase.VIG < 0) {
            capDisplay[7] = { capacidade: 'VIGOR', sigla: 'VIG', valor: capsBase.VIG }
        }

        if (capsBase.IMD > 0) {
            capDisplay[8] = { capacidade: 'IMUNIDADE', sigla: 'IMD', valor: '+' + capsBase.IMD }
        } else if (capsBase.IMD < 0) {
            capDisplay[8] = { capacidade: 'IMUNIDADE', sigla: 'IMD', valor: capsBase.IMD }
        }

        if (capsBase.RAZ > 0) {
            capDisplay[9] = { capacidade: 'RAZÃO', sigla: 'RAZ', valor: '+' + capsBase.RAZ }
        } else if (capsBase.RAZ < 0) {
            capDisplay[9] = { capacidade: 'RAZÃO', sigla: 'RAZ', valor: capsBase.RAZ }
        }

        if (capsBase.OBT > 0) {
            capDisplay[10] = { capacidade: 'OBSTINAÇÃO', sigla: 'OBT', valor: '+' + capsBase.OBT }
        } else if (capsBase.OBT < 0) {
            capDisplay[10] = { capacidade: 'OBSTINAÇÃO', sigla: 'OBT', valor: capsBase.OBT }
        }

        if (capsBase.ATN > 0) {
            capDisplay[11] = { capacidade: 'ATENÇÃO', sigla: 'ATN', valor: '+' + capsBase.ATN }
        } else if (capsBase.ATN < 0) {
            capDisplay[11] = { capacidade: 'ATENÇÃO', sigla: 'ATN', valor: capsBase.ATN }
        }

        if (capsBase.RET > 0) {
            capDisplay[12] = { capacidade: 'RETÓRICA', sigla: 'RET', valor: '+' + capsBase.RET }
        } else if (capsBase.RET < 0) {
            capDisplay[12] = { capacidade: 'RETÓRICA', sigla: 'RET', valor: capsBase.RET }
        }

        if (capsBase.CAR > 0) {
            capDisplay[13] = { capacidade: 'CARISMA', sigla: 'CAR', valor: '+' + capsBase.CAR }
        } else if (capsBase.CAR < 0) {
            capDisplay[13] = { capacidade: 'CARISMA', sigla: 'CAR', valor: capsBase.CAR }
        }

        if (capsBase.IMP > 0) {
            capDisplay[14] = { capacidade: 'IMPOSIÇÃO', sigla: 'IMP', valor: '+' + capsBase.IMP }
        } else if (capsBase.IMP < 0) {
            capDisplay[14] = { capacidade: 'IMPOSIÇÃO', sigla: 'IMP', valor: capsBase.IMP }
        }

        return capDisplay;
    },

    capsChosed(especie, raca, qualidade, defeito, trn1, trn2, trn3) {

        let capDisplay = []
        capDisplay[0] = {
            capacidade: '',
            sigla: '',
            Especie: especie.nome,
            Raça: raca.nome,
            Qualidade: qualidade.nome,
            Defeito: defeito.nome,
            Treinamento_1: trn1.nome,
            Treinamento_2: trn2.nome,
            Treinamento_3: trn3.nome,
            Personagem: ""
        }
        capDisplay[1] = {
            capacidade: 'FORÇA',
            sigla: 'FRC',
            Especie: especie.capacidades.FRC,
            Raça: raca.capacidades.FRC,
            Qualidade: qualidade.capacidades.FRC,
            Defeito: defeito.capacidades.FRC,
            Treinamento_1: trn1.capacidades.FRC,
            Treinamento_2: trn2.capacidades.FRC,
            Treinamento_3: trn3.capacidades.FRC,
            Personagem: especie.capacidades.FRC
                + raca.capacidades.FRC
                + qualidade.capacidades.FRC
                + defeito.capacidades.FRC
                + trn1.capacidades.FRC
                + trn2.capacidades.FRC
                + trn3.capacidades.FRC
        }
        capDisplay[2] = {
            capacidade: 'MOBILIDADE',
            sigla: 'MOB',
            Especie: especie.capacidades.MOB,
            Raça: raca.capacidades.MOB,
            Qualidade: qualidade.capacidades.MOB,
            Defeito: defeito.capacidades.MOB,
            Treinamento_1: trn1.capacidades.MOB,
            Treinamento_2: trn2.capacidades.MOB,
            Treinamento_3: trn3.capacidades.MOB,
            Personagem: especie.capacidades.MOB
                + raca.capacidades.MOB
                + qualidade.capacidades.MOB
                + defeito.capacidades.MOB
                + trn1.capacidades.MOB
                + trn2.capacidades.MOB
                + trn3.capacidades.MOB
        }

        capDisplay[3] = {
            capacidade: 'RESISTÊNCIA',
            sigla: 'RES',
            Especie: especie.capacidades.RES,
            Raça: raca.capacidades.RES,
            Qualidade: qualidade.capacidades.RES,
            Defeito: defeito.capacidades.RES,
            Treinamento_1: trn1.capacidades.RES,
            Treinamento_2: trn2.capacidades.RES,
            Treinamento_3: trn3.capacidades.RES,
            Personagem: especie.capacidades.RES
                + raca.capacidades.RES
                + qualidade.capacidades.RES
                + defeito.capacidades.RES
                + trn1.capacidades.RES
                + trn2.capacidades.RES
                + trn3.capacidades.RES
        }

        capDisplay[4] = {
            capacidade: 'AGILIDADE',
            sigla: 'AGL',
            Especie: especie.capacidades.AGL,
            Raça: raca.capacidades.AGL,
            Qualidade: qualidade.capacidades.AGL,
            Defeito: defeito.capacidades.AGL,
            Treinamento_1: trn1.capacidades.AGL,
            Treinamento_2: trn2.capacidades.AGL,
            Treinamento_3: trn3.capacidades.AGL,
            Personagem: especie.capacidades.AGL
                + raca.capacidades.AGL
                + qualidade.capacidades.AGL
                + defeito.capacidades.AGL
                + trn1.capacidades.AGL
                + trn2.capacidades.AGL
                + trn3.capacidades.AGL
        }

        capDisplay[5] = {
            capacidade: 'SUTILEZA',
            sigla: 'STZ',
            Especie: especie.capacidades.STZ,
            Raça: raca.capacidades.STZ,
            Qualidade: qualidade.capacidades.STZ,
            Defeito: defeito.capacidades.STZ,
            Treinamento_1: trn1.capacidades.STZ,
            Treinamento_2: trn2.capacidades.STZ,
            Treinamento_3: trn3.capacidades.STZ,
            Personagem: especie.capacidades.STZ
                + raca.capacidades.STZ
                + qualidade.capacidades.STZ
                + defeito.capacidades.STZ
                + trn1.capacidades.STZ
                + trn2.capacidades.STZ
                + trn3.capacidades.STZ
        }

        capDisplay[6] = {
            capacidade: 'DESENVOLTURA',
            sigla: 'DSV',
            Especie: especie.capacidades.DSV,
            Raça: raca.capacidades.DSV,
            Qualidade: qualidade.capacidades.DSV,
            Defeito: defeito.capacidades.DSV,
            Treinamento_1: trn1.capacidades.DSV,
            Treinamento_2: trn2.capacidades.DSV,
            Treinamento_3: trn3.capacidades.DSV,
            Personagem: especie.capacidades.DSV
                + raca.capacidades.DSV
                + qualidade.capacidades.DSV
                + defeito.capacidades.DSV
                + trn1.capacidades.DSV
                + trn2.capacidades.DSV
                + trn3.capacidades.DSV
        }

        capDisplay[7] = {
            capacidade: 'TENACIDADE',
            sigla: 'TNA',
            Especie: especie.capacidades.TNA,
            Raça: raca.capacidades.TNA,
            Qualidade: qualidade.capacidades.TNA,
            Defeito: defeito.capacidades.TNA,
            Treinamento_1: trn1.capacidades.TNA,
            Treinamento_2: trn2.capacidades.TNA,
            Treinamento_3: trn3.capacidades.TNA,
            Personagem: especie.capacidades.TNA
                + raca.capacidades.TNA
                + qualidade.capacidades.TNA
                + defeito.capacidades.TNA
                + trn1.capacidades.TNA
                + trn2.capacidades.TNA
                + trn3.capacidades.TNA
        }

        capDisplay[8] = {
            capacidade: 'VIGOR',
            sigla: 'VIG',
            Especie: especie.capacidades.VIG,
            Raça: raca.capacidades.VIG,
            Qualidade: qualidade.capacidades.VIG,
            Defeito: defeito.capacidades.VIG,
            Treinamento_1: trn1.capacidades.VIG,
            Treinamento_2: trn2.capacidades.VIG,
            Treinamento_3: trn3.capacidades.VIG,
            Personagem: especie.capacidades.VIG
                + raca.capacidades.VIG
                + qualidade.capacidades.VIG
                + defeito.capacidades.VIG
                + trn1.capacidades.VIG
                + trn2.capacidades.VIG
                + trn3.capacidades.VIG
        }

        capDisplay[9] = {
            capacidade: 'IMUNIDADE',
            sigla: 'IMD',
            Especie: especie.capacidades.IMD,
            Raça: raca.capacidades.IMD,
            Qualidade: qualidade.capacidades.IMD,
            Defeito: defeito.capacidades.IMD,
            Treinamento_1: trn1.capacidades.IMD,
            Treinamento_2: trn2.capacidades.IMD,
            Treinamento_3: trn3.capacidades.IMD,
            Personagem: especie.capacidades.IMD
                + raca.capacidades.IMD
                + qualidade.capacidades.IMD
                + defeito.capacidades.IMD
                + trn1.capacidades.IMD
                + trn2.capacidades.IMD
                + trn3.capacidades.IMD
        }

        capDisplay[10] = {
            capacidade: 'RAZÃO',
            sigla: 'RAZ',
            Especie: especie.capacidades.RAZ,
            Raça: raca.capacidades.RAZ,
            Qualidade: qualidade.capacidades.RAZ,
            Defeito: defeito.capacidades.RAZ,
            Treinamento_1: trn1.capacidades.RAZ,
            Treinamento_2: trn2.capacidades.RAZ,
            Treinamento_3: trn3.capacidades.RAZ,
            Personagem: especie.capacidades.RAZ
                + raca.capacidades.RAZ
                + qualidade.capacidades.RAZ
                + defeito.capacidades.RAZ
                + trn1.capacidades.RAZ
                + trn2.capacidades.RAZ
                + trn3.capacidades.RAZ
        }

        capDisplay[11] = {
            capacidade: 'OBSTINAÇÃO',
            sigla: 'OBT',
            Especie: especie.capacidades.OBT,
            Raça: raca.capacidades.OBT,
            Qualidade: qualidade.capacidades.OBT,
            Defeito: defeito.capacidades.OBT,
            Treinamento_1: trn1.capacidades.OBT,
            Treinamento_2: trn2.capacidades.OBT,
            Treinamento_3: trn3.capacidades.OBT,
            Personagem: especie.capacidades.OBT
                + raca.capacidades.OBT
                + qualidade.capacidades.OBT
                + defeito.capacidades.OBT
                + trn1.capacidades.OBT
                + trn2.capacidades.OBT
                + trn3.capacidades.OBT
        }

        capDisplay[12] = {
            capacidade: 'ATENÇÃO',
            sigla: 'ATN',
            Especie: especie.capacidades.ATN,
            Raça: raca.capacidades.ATN,
            Qualidade: qualidade.capacidades.ATN,
            Defeito: defeito.capacidades.ATN,
            Treinamento_1: trn1.capacidades.ATN,
            Treinamento_2: trn2.capacidades.ATN,
            Treinamento_3: trn3.capacidades.ATN,
            Personagem: especie.capacidades.ATN
                + raca.capacidades.ATN
                + qualidade.capacidades.ATN
                + defeito.capacidades.ATN
                + trn1.capacidades.ATN
                + trn2.capacidades.ATN
                + trn3.capacidades.ATN
        }

        capDisplay[13] = {
            capacidade: 'RETÓRICA',
            sigla: 'RET',
            Especie: especie.capacidades.RET,
            Raça: raca.capacidades.RET,
            Qualidade: qualidade.capacidades.RET,
            Defeito: defeito.capacidades.RET,
            Treinamento_1: trn1.capacidades.RET,
            Treinamento_2: trn2.capacidades.RET,
            Treinamento_3: trn3.capacidades.RET,
            Personagem: especie.capacidades.RET
                + raca.capacidades.RET
                + qualidade.capacidades.RET
                + defeito.capacidades.RET
                + trn1.capacidades.RET
                + trn2.capacidades.RET
                + trn3.capacidades.RET
        }

        capDisplay[14] = {
            capacidade: 'CARISMA',
            sigla: 'CAR',
            Especie: especie.capacidades.CAR,
            Raça: raca.capacidades.CAR,
            Qualidade: qualidade.capacidades.CAR,
            Defeito: defeito.capacidades.CAR,
            Treinamento_1: trn1.capacidades.CAR,
            Treinamento_2: trn2.capacidades.CAR,
            Treinamento_3: trn3.capacidades.CAR,
            Personagem: especie.capacidades.CAR
                + raca.capacidades.CAR
                + qualidade.capacidades.CAR
                + defeito.capacidades.CAR
                + trn1.capacidades.CAR
                + trn2.capacidades.CAR
                + trn3.capacidades.CAR
        }

        capDisplay[15] = {
            capacidade: 'IMPOSIÇÃO',
            sigla: 'IMP',
            Especie: especie.capacidades.IMP,
            Raça: raca.capacidades.IMP,
            Qualidade: qualidade.capacidades.IMP,
            Defeito: defeito.capacidades.IMP,
            Treinamento_1: trn1.capacidades.IMP,
            Treinamento_2: trn2.capacidades.IMP,
            Treinamento_3: trn3.capacidades.IMP,
            Personagem: especie.capacidades.IMP
                + raca.capacidades.IMP
                + qualidade.capacidades.IMP
                + defeito.capacidades.IMP
                + trn1.capacidades.IMP
                + trn2.capacidades.IMP
                + trn3.capacidades.IMP
        }


        return capDisplay;
    },

    capsCleanByTotal(capsBase) {
        let capsClean = []
        capsBase.splice(0, 1);
        for (let i = 0; i < 14; i++) {   
            if((capsBase[i].Especie != 0) || (capsBase[i].Raça != 0)){
                capsClean.push(capsBase[i])
            }            
        }
        return capsClean;
    }
}