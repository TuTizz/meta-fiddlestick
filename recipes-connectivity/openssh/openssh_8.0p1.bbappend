FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

AUTHORIZED_KEYS ?= ""
SRC_URI += "file://sshd_config \
            "

FILES_${PN} += " \
    ${ROOT_HOME}/.ssh \
"

do_install_append() {
	bbnote "AUTHORIZED_KEYS is set to invalid value : \"${AUTHORIZED_KEYS} \" "

	if [ -e "${AUTHORIZED_KEYS}" ]; then 
		install -d ${D}${ROOT_HOME}/.ssh
		install -m 0644 ${AUTHORIZED_KEYS} ${D}${ROOT_HOME}/.ssh/authorized_keys
	else
		bbfatal "ERROR: AUTHORIZED_KEYS variable is set to invalid value file does not exist : \"${AUTHORIZED_KEYS} \". Change your local.conf to put AUTHORIZED_KEYS=\"<file>\" "
	fi
	
}
