package lib

import (
	"github.com/stretchr/testify/assert"

	"testing"
)

func TestGetEnvironment(t *testing.T) {
	environment := NewEnvironment()
	assert.Equal(t, false, environment.Debug)
	assert.Equal(t, "", environment.ConversationsTablename)
	assert.Equal(t, 0, len(environment.SuperuserPhones))
	assert.Equal(t, "", environment.TwilioAccountSid)
	assert.Equal(t, "", environment.TwilioAuthToken)
	assert.Equal(t, "", environment.FromPhone)
	assert.Equal(t, "", environment.NotifiesTablename)
}
