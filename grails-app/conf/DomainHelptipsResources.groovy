modules = {

  'domain-helptips' {
    dependsOn 'jquery-ui', 'jquery'

    resource id: 'js',
      url: [plugin: 'domainHelptips', dir: 'js', file: 'helptips.js'],
      disposition: 'head'

    resource id: 'js',
      url: [plugin: 'domainHelptips', dir: 'js', file: 'jquery.bt.custom.js'],
      nominify: true,
      disposition: 'head'

    resource id: 'theme',
      url: [plugin: 'domainHelptips', dir: 'css', file: 'helptips.css'],
      nohashandcache: true,
      disposition: 'head'

  }

}
