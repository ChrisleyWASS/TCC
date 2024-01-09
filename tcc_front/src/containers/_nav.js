export default [
  {
    _name: 'CSidebarNav',
    _children: [
      {
        _name: 'CSidebarNavItem',
        name: 'Home',
        to: '/dashboard',
        icon: 'cil-home',        
      },
      {
        _name: 'CSidebarNavTitle',
        _children: ['Jogo']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Personagem',
        icon: 'cil-user',
        items: [
          {
            name: 'Novo Personagem',
            to: '/personagens/new',
          },
          {
            name: 'Lista de Personagens',
            to: '/personagens/list',
          },
          
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Sala',
        icon: 'cil-mobile-landscape',
        items: [
          {
            name: 'Nova Sala',
            to: '/sala/new',
          },
          {
            name: 'Lista de Salas',
            to: '/sala/list',
          },          
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Progressão',
        icon: 'cil-sort-ascending',
        items: [
          {
            name: 'Habilidades',
            to: '/produtos/unidades'
          },
          {
            name: 'Itens',
            to: '/produtos/linhas'
          },
          {
            name: 'Criação de Itens',
            to: '/produtos/linhas'
          },
        ]
      },    
      {
        _name: 'CSidebarNavTitle',
        _children: ['Regras']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Introdução',
        icon: 'cil-info',
        items: [
          {
            name: 'O que é RPG',
            to: '/empresas/empresa',              
          },
          {
            name: 'Preparação',
            to: '/empresas/filiais'
          }, 
          {
            name: 'Sobre este jogo',
            to: '/empresas/filiais'
          },           
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Atributos',
        icon: 'cil-bar-chart',
        items: [
          {
            name: 'Capacidades',
            to: '/pessoas/pessoas',            
          },
          {
            name: 'Conhecimentos',
            to: '/pessoas/pessoas',            
          }
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Mecânicas Básicas',
        icon: 'cil-casino',
        items: [
          {
            name: 'Testes',
            to: '/pessoas/pessoas',            
          },
          {
            name: 'Redutores',
            to: '/pessoas/pessoas',            
          },
          {
            name: 'Colapsto',
            to: '/pessoas/pessoas',            
          }
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Mecânicas de Combate',
        icon: 'cil-x-circle',
        items: [
          {
            name: 'Redutores',
            to: '/produtos/unidades'
          },
          {
            name: 'Colapso',
            to: '/produtos/linhas'
          },
        ]
      }, 
        
      {
        _name: 'CSidebarNavTitle',
        _children: ['Cenário']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Fundamentos',
        icon: 'cil-globe-alt',
        items: [
          {
            name: 'Apresentação',
            to: '/nfes/nfe'
          },
          {
            name: 'Mysthen',
            to: '/nfes/nfe'
          },
        ]
      },  
      {
        _name: 'CSidebarNavDropdown',
        name: 'Cronologia',
        icon: 'cil-history',
        items: [
          {
            name: 'As 9 Eras',
            to: '/nfes/nfe'
          },
        ]
      }, 
      {
        _name: 'CSidebarNavDropdown',
        name: 'Instituições',
        icon: 'cil-library-building',
        items: [
          {
            name: 'Civilizações',
            to: '/nfes/nfe'
          },
          {
            name: 'Arcanismo',
            to: '/nfes/nfe'
          },
          {
            name: 'Religiões',
            to: '/nfes/nfe'
          }
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Espécies',
        icon: 'cil-lan',
        items: [
          {
            name: 'Raças jogáveis',
            to: '/nfes/nfe'
          },
          {
            name: 'Animais',
            to: '/nfes/nfe'
          },
          {
            name: 'Ipheraks',
            to: '/nfes/nfe'
          },
          {
            name: 'Ankhaithans',
            to: '/nfes/nfe'
          },
          {
            name: 'Dracônicos',
            to: '/nfes/nfe'
          },
        ]
      }, 
      {
        _name: 'CSidebarNavTitle',
        _children: ['Sistema']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Perfil',
        icon: 'cil-at',
        items: [
          {
            name: 'Dados Pessoais',
            to: '/financeiro/tiposdocumentos',            
          },
          {
            name: 'Amigos',
            to: '/financeiro/documentos',            
          },
          {
            name: 'Segurança',
            to: '/financeiro/baixa',            
          }, 
        ]
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Configuração',
        icon: 'cil-cog',
        items: [
          {
            name: 'Conexão',
            to: '/financeiro/tiposdocumentos',            
          },
          {
            name: 'Info',
            to: '/financeiro/documentos',            
          },
        ]
      },      
      {
        _name: 'CSidebarNavDropdown',
        name: 'Sair',
        icon: 'cil-account-logout',
        items: [
          {
            name: 'Voltar ao Login',
            to: '/login',
            id: 'stock_moviment_type_register',
          },
          {
            name: 'Fechar Aplicação',
            to: '/cobranca/remessa',
            id: 'process_moviment_stock',
          },          
        ]
      },  
      
    ]
  }
]