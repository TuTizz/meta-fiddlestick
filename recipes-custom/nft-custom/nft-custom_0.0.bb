LICENSE = "MIT"

NFTABLES_CONF_FILE ?= ""
RDEPENDS_{PN}="nftables"
FILES_${PN} += " \
	${sysconfdir}/nftables/nftables.rules \
"

do_install_append() {
	bbnote "NFTABLES_CONF_FILE is set to invalid value : \"${NFTABLES_CONF_FILE} \" "

	if [ -e "${NFTABLES_CONF_FILE}" ]; then 
	        install -d ${D}${sysconfdir}/nftables
        	install -m 0644 ${NFTABLES_CONF_FILE} ${D}${sysconfdir}/nftables/nftables.rules
	else
		bbfatal "ERROR: NFTABLES_CONF_FILE variable is set to invalid value file does not exist : \"${NFTABLES_CONF_FILE} \". Change your local.conf to put NFTABLES_CONF_FILE=\"<file>\" if needed, copy the one available in this subfolder."
	fi
}

