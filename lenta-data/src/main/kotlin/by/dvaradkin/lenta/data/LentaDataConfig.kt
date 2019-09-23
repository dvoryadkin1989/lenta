package by.dvaradkin.lenta.data

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("by.dvaradkin.lenta.data")
open class LentaDataConfig {
}