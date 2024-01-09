import moment from 'moment'

export default {
    
    formatDocument(type, document) {  
        if (type === 'F')
            return formatCpf(document);
        else if (type === 'J')
            return formatCnpj(document);        
        else
            return document;
    },

    formatPhone(phone) {
        if (phone.length === 11) 
            return phone.replace(/(\d{2})(\d{5})(\d{4})/, "($1) $2-$3");            
        else
            return phone.replace(/(\d{2})(\d{4})(\d{4})/, "($1) $2-$3");
    },

    formatDate(date) {        
        return moment(String(date)).format('DD/MM/YYYY')
    },

    formatHour(date) {        
        return moment(String(date)).format('HH:mm')
    },

    formatDateTime(date) {   
        if (date === null)
            return "";
        else     
            return moment(String(date)).format('DD/MM/YYYY HH:mm');
    },
}

function formatCpf(cpf) {
    return cpf
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d{1,2})$/, "$1-$2");
};

function formatCnpj(cnpj) {
    return cnpj
        .replace(/(\d{2})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1/$2")
        .replace(/(\d{4})(\d{1,2})$/, "$1-$2");
};
